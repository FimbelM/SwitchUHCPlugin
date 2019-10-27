package fr.pederobien.uhc.game.blockedexgame;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.managers.BaseManager;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.managers.WorldManager;

public class StartedState extends AbstractBlockedexState {
	private List<Player> collegues;

	public StartedState(IBlockedexGame game) {
		super(game);
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
		if (bdPlayerManager.isTeamPlayerEliminated(event.getPlayer()))
			event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		else if (collegues.size() > 0)
			event.setRespawnLocation(TeamsManager.getRandom(collegues).getLocation());
		else
			event.setRespawnLocation(WorldManager.getRandomlyLocation(game.getConfiguration().getDiameterAreaOnPlayerRespawn()));
	}
	
	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (!BaseManager.isChestAccessible(event.getPlayer(), event.getClickedBlock()))
			event.setCancelled(true);
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
		collegues.forEach(p -> bdPlayerManager.decreaseMaxHealth(p, game.getConfiguration().getStepOnMaxHealth()));
		collegues.remove(player);
	}

	private void onPlayerDieByPlayer(Player player) {
		List<Player> players = PlayerManager.getCloseCollegues(player, game.getConfiguration().getRadiusAreaOnPlayerDie());
		if (players.size() > 0) {
			players.add(player);
			players.forEach(p -> bdPlayerManager.decreaseMaxHealth(p, game.getConfiguration().getStepOnMaxHealth()));
		} else
			bdPlayerManager.decreaseMaxHealth(player, game.getConfiguration().getDoubleStepOnMaxHealth());
	}

	private void onPlayerKill(Player player) {
		List<Player> players = PlayerManager.getCloseCollegues(player, game.getConfiguration().getRadiusAreaOnPlayerKill());
		if (players.size() > 0) {
			players.add(player);
			players.forEach(p -> bdPlayerManager.increaseMaxHealth(p, game.getConfiguration().getStepOnMaxHealth()));
		} else
			bdPlayerManager.increaseMaxHealth(player, game.getConfiguration().getDoubleStepOnMaxHealth());
	}
}
