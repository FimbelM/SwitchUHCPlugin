package fr.martinfimbel.switchuhc.game.blockedexgame;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.event.InventoryClickResponse;
import fr.martinfimbel.switchuhc.event.PlayerInteractEventResponse;
import fr.martinfimbel.switchuhc.interfaces.IMessageCode;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.managers.BaseManager;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class StartedState extends AbstractBlockedexState {
	private List<Player> collegues;

	public StartedState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void pause() {
		onPause();
	}

	@Override
	public void relaunch() {
		onRelaunched();
	}

	@Override
	public void stop() {
		game.setCurrentState(game.getStop()).stop();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		event.setKeepInventory(true);
		Player player = event.getEntity();
		collegues = TeamsManager.getCollegues(player);

		onPlayerDie(player);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Location center = WorldManager.createDefaultLocation(0, WorldManager.getHighestBlockYAt(0, 0).getY(), 0);
		if (bdPlayerManager.isTeamPlayerEliminated(event.getPlayer()))
			event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		else if (collegues.size() > 0)
			event.setRespawnLocation(TeamsManager.getRandom(collegues).getLocation());
		else
			
			event.setRespawnLocation(WorldManager.getRandomlyLocation(getConfiguration().getDiameterAreaOnPlayerRespawn(), center));
	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		ITeam playerTeam = TeamsManager.getTeam(event.getPlayer());
		PlayerInteractEventResponse response = BaseManager.isRestricted(event);
		ITeam allowedTeam = TeamsManager.getTeam(response.getColorAllowed());
		if (!response.isRestricted())
			return;

		event.setCancelled(true);
		sendMessage(event.getPlayer(), MessageCode.CHEST_IS_RESTRICTED, allowedTeam.getColoredName(), playerTeam.getColoredName());
	}

	@Override
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		InventoryClickResponse response = BaseManager.canDropItem(event);

		if (response.canDropItem())
			return;

		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		IMessageCode code;

		if (response.isBlockAlreadyDropped())
			code = MessageCode.CANNOT_DROP_ITEM_ITEM_ALREADY_DROPPED;
		else if (response.isBlockForbidden())
			code = MessageCode.CANNOT_DROP_ITEM_ITEM_FORBIDDEN;
		else
			code = MessageCode.CANNOT_GET_ITEM_BACK;

		sendMessage(player, code);
	}

	private void onPlayerDie(Player player) {
		if (player.getKiller() instanceof Player) {
			onPlayerDieByPlayer(player);
			onPlayerKill(player.getKiller());
		} else
			onPlayerDieByEnvironment(player);

		bdPlayerManager.decreasePlayerTeamMaxDeath(player);
	}

	private void onPlayerDieByEnvironment(Player player) {
		collegues.add(player);
		collegues.forEach(p -> bdPlayerManager.decreaseMaxHealth(p, getConfiguration().getStepOnMaxHealth()));
		collegues.remove(player);
	}

	private void onPlayerDieByPlayer(Player player) {
		List<Player> players = PlayerManager.getCloseCollegues(player, getConfiguration().getRadiusAreaOnPlayerDie());
		if (players.size() > 0) {
			players.add(player);
			players.forEach(p -> bdPlayerManager.decreaseMaxHealth(p, getConfiguration().getStepOnMaxHealth()));
		} else
			bdPlayerManager.decreaseMaxHealth(player, getConfiguration().getDoubleStepOnMaxHealth());
	}

	private void onPlayerKill(Player player) {
		List<Player> players = PlayerManager.getCloseCollegues(player, getConfiguration().getRadiusAreaOnPlayerKill());
		if (players.size() > 0) {
			players.add(player);
			players.forEach(p -> bdPlayerManager.increaseMaxHealth(p, getConfiguration().getStepOnMaxHealth()));
		} else
			bdPlayerManager.increaseMaxHealth(player, getConfiguration().getDoubleStepOnMaxHealth());
	}
}
