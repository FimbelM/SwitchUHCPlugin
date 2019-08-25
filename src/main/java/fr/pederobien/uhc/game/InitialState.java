package fr.pederobien.uhc.game;

import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.scoreboard.Scoreboard;
import fr.pederobien.uhc.task.ScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractState {
	
	public InitialState(IGame game) {
		super(game);
	}
	
	@Override
	public void initiate() {
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime(), game.getConfiguration().getFractionTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboard = new Scoreboard(taskLauncher.getTask());
		scoreboardLauncher = new ScoreboardLauncher(scoreboard);
		
		timeLine.addObserver(game.getConfiguration().getGameTime(), game);
		timeLine.addObserver(game.getConfiguration().getFractionTime(), game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), scoreboard);
		game.getEventListener().addObservers(game);
				
		WorldManager.setPVP(false);
		WorldManager.setSpawnOnJoin(game.getConfiguration().getSpawn().getCenter().getLocation());
	}
	
	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		PlayerManager.setGameModeOfPlayer(event.getPlayer(), GameMode.ADVENTURE);
	}
}
