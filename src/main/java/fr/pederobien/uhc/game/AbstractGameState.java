package fr.pederobien.uhc.game;

import org.bukkit.GameMode;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

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
	
	protected void onStart() {
		PlayerManager.giveEffects("@a", "resistance", "regeneration", "saturation");
		PlayerManager.maxFoodForPlayers();
		PlayerManager.maxLifeToPlayers();
		PlayerManager.removeInventoryOfPlayers();
		PlayerManager.setGameModeOfPlayers(GameMode.SURVIVAL);
		WorldManager.setTimeDay();
		WorldManager.setWeatherSun();
	}
}
