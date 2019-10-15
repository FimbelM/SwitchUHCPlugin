package fr.pederobien.uhc.game;

import org.bukkit.GameMode;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffectType;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.scoreboard.launcher.IScoreboardLauncher;
import fr.pederobien.uhc.task.ITaskLauncher;

public abstract class AbstractGameState implements IGameState {
	protected static ITaskLauncher taskLauncher;
	protected static IScoreboardLauncher scoreboardLauncher;

	@Override
	public void initiate() {
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
	public void time() {

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

	protected void onStart() {
		PlayerManager.giveEffectToAllPlayers(PotionEffectType.DAMAGE_RESISTANCE,
				PotionEffectType.REGENERATION, PotionEffectType.SATURATION);
		PlayerManager.maxFoodForPlayers();
		PlayerManager.resetMaxHealthOfPlayers();
		PlayerManager.maxLifeToPlayers();
		PlayerManager.removeInventoryOfPlayers();
		PlayerManager.setGameModeOfPlayers(GameMode.SURVIVAL);
		WorldManager.setTimeDay();
		WorldManager.setWeatherSun();
	}

	protected void onStop() {
		taskLauncher.cancel();
		scoreboardLauncher.cancel();
		PlayerManager.teleporteAllPlayers(WorldManager.getSpawnOnJoin());
	}
}
