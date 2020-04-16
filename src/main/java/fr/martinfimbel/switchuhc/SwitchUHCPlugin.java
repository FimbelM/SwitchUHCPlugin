package fr.martinfimbel.switchuhc;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import fr.martinfimbel.switchuhc.commands.configuration.CommandFactory;
import fr.martinfimbel.switchuhc.configurations.ConfigurationContext;
import fr.martinfimbel.switchuhc.environment.UHCPlayer;
import fr.martinfimbel.switchuhc.game.GameStateException;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;
import fr.martinfimbel.switchuhc.observers.IObsGame;
import fr.martinfimbel.switchuhc.observers.IObsListener;
import fr.martinfimbel.switchuhc.scoreboard.ScoreboardStateException;
import fr.martinfimbel.switchuhc.world.EventListener;

public class SwitchUHCPlugin extends JavaPlugin implements IObsListener, IObsGame {
	private IConfigurationContext context;
	private EventListener listener;

	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		getLogger().info("Switch UHC plugin Enable");

		SwitchPluginDeposit.plugin = this;
		context = new ConfigurationContext();
		listener = new EventListener();

		getServer().getPluginManager().registerEvents(listener, this);

		WorldManager.setTimeDay();
		WorldManager.setWeatherSun();
		WorldManager.setPVP(false);
		WorldManager.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
		
		CommandFactory.initiate(this, context);

		listener.addObservers(this);

		PlayerManager.getPlayers().forEach(p -> UHCPlayer.register(p));
		PlayerManager.getPlayers().forEach(p -> p.setPlayerListHeaderFooter(ChatColor.GOLD + "Switch UHC", ChatColor.AQUA + "PE & MARTIN"));
		
	}

	@Override
	public void onDisable() {
		getLogger().info("Switch UHC plugin disable");
		try {
			WorldManager.removeSpawn();
			context.stop();
		} catch (GameStateException | ScoreboardStateException | NullPointerException e) {

		}
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		PlayerManager.removeAllEffectsToAllPlayers();
		listener.removeObservers(this);
		listener.addObservers(context);

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		listener.addObservers(this);
		listener.removeObservers(context);
		WorldManager.setPVP(false);
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		// TODO Auto-generated method stub
		String message = "Bienvenue en " + ChatColor.AQUA + ChatColor.BOLD + "UHC Switch";
		event.getPlayer().sendMessage(message + " " + event.getPlayer().getName());
		UHCPlayer.register(event.getPlayer());
		PlayerManager.teleporte(event.getPlayer(), WorldManager.createDefaultLocation(0, 70, 0));
		movePlayer(event.getPlayer());
	}

	private void movePlayer(Player player) {
		// TODO Auto-generated method stub
		if (BukkitManager.getOperators().contains(player))
			PlayerManager.setGameModeOfPlayer(player, GameMode.CREATIVE);
		else {
			PlayerManager.setGameModeOfPlayer(player, GameMode.ADVENTURE);
			PlayerManager.giveEffects(player, PlayerManager.createEffectMaxDurationMaxModifier(
					PotionEffectType.REGENERATION, PotionEffectType.SATURATION, PotionEffectType.DAMAGE_RESISTANCE));
		}
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		// TODO Auto-generated method stub
		event.setRespawnLocation(WorldManager.getSpawnOnJoin());
		movePlayer(event.getPlayer());
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPlayerPortalEvent(PlayerPortalEvent event) {
		// TODO Auto-generated method stub

	}

}
