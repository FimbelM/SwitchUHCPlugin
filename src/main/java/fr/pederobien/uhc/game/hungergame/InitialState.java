package fr.pederobien.uhc.game.hungergame;

import java.time.Duration;

import fr.pederobien.uhc.managers.TeamsManager;
import fr.pederobien.uhc.scoreboard.launcher.HGScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractHungerGameState {

	public InitialState(IHungerGame game) {
		super(game);
	}

	@Override
	public boolean initiate() {
		if (Duration.between(game.getConfiguration().getFractionTime(), game.getConfiguration().getGameTime()).isNegative()) {
			message = "The fraction time must be less than the game time";
			return false;
		}
		
		TeamsManager.setCurrentConfiguration(game.getConfiguration());
		
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new HGScoreboardLauncher(taskLauncher.getTask(), game.getConfiguration().getTeams());
		
		warningTime = game.getConfiguration().getGameTime().minusMinutes(1);

		timeLine.addObserver(game.getConfiguration().getFractionTime(), game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), game);
		timeLine.addObserver(warningTime, game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), scoreboardLauncher);
		return true;
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
