package fr.pederobien.uhc.game;

import java.time.LocalTime;

import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.dictionary.NotificationCenter;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.scoreboard.launcher.IScoreboardLauncher;
import fr.pederobien.uhc.task.ITaskLauncher;

public abstract class AbstractGameState implements IGameState {
	protected static ITaskLauncher taskLauncher;
	protected static IScoreboardLauncher scoreboardLauncher;
	protected MessageCode message;

	@Override
	public boolean initiate() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void start() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void pause() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void relaunch() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void stop() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public MessageCode getMessage() {
		return message;
	}

	@Override
	public void time(LocalTime time) {

	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {

	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {

	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {

	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {

	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {

	}

	@Override
	public void onPlayerInteract(PlayerInteractEvent event) {

	}

	@Override
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (WorldManager.isLocationUnderSpawn(event.getLocation()) && WorldManager.MOBS.contains(event.getEntityType()))
			event.setCancelled(true);
	}

	@Override
	public void onPlayerPortalEvent(PlayerPortalEvent event) {

	}

	protected void onStart() {
		PlayerManager.giveEffectToAllPlayers(PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.REGENERATION, PotionEffectType.SATURATION);
		PlayerManager.maxFoodForPlayers();
		PlayerManager.resetMaxHealthOfPlayers();
		PlayerManager.maxLifeToPlayers();
		PlayerManager.removeInventoryOfPlayers();
		PlayerManager.setGameModeOfPlayers(GameMode.SURVIVAL);
		WorldManager.setTimeDay();
		WorldManager.setWeatherSun();
		WorldManager.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
	}

	protected void onStop() {
		taskLauncher.cancel();
		scoreboardLauncher.cancel();
		PlayerManager.teleporteAllPlayers(WorldManager.getSpawnOnJoin());
	}

	protected void sendMessage(Player player, IMessageCode code, String... args) {
		NotificationCenter.sendMessage(EventFactory.createMessageEvent(player, code, args));
	}

	protected void sendTitle(IMessageCode code, String... args) {
		BukkitManager.sendTitleToPlayers(EventFactory.createMessageCodeEvent(code, args));
	}

	protected void sendTitle(EColor color, IMessageCode code, String... args) {
		BukkitManager.sendTitleToPlayers(EventFactory.createMessageCodeEvent(code, args), color);
	}
}
