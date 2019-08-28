package fr.pederobien.uhc.game.hungergame;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.scoreboard.Scoreboard;
import fr.pederobien.uhc.task.ScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public abstract class AbstractState implements IGameState {
	protected IGame game;
	protected static TaskLauncher taskLauncher;
	protected static ScoreboardLauncher scoreboardLauncher; 
	protected static TimeLine timeLine;
	protected static Scoreboard scoreboard;
	
	public AbstractState(IGame game) {
		this.game = game;
	}
	
	@Override
	public void initiate() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void start() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void pause(IGameState before) {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void relaunched() {
		throw new GameStateException("This method cannot be called by this state");
	}

	@Override
	public void stop() {
		throw new GameStateException("This method cannot be called by this state");
	}
	
	public void onPlayerDie(PlayerDeathEvent event) {
		for (Player player : PlayerManager.getPlayers())
			player.playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH, 10, 1);
	}

	public void onPlayerJoin(PlayerJoinEvent event) {
		
	}

	public void onPlayerMove(PlayerMoveEvent event) {
		
	}

	public void onPlayerQuit(PlayerQuitEvent event) {
		
	}

	public void onPlayerRespawn(PlayerRespawnEvent event) {
		
	}

	public void run() {
		
	}
}