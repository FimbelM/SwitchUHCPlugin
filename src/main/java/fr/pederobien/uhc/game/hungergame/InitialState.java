package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.scoreboard.launcher.HGScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractHungerGameState {

	public InitialState(IHungerGame game) {
		super(game);
	}

	@Override
	public void initiate() {
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new HGScoreboardLauncher(taskLauncher.getTask());

		timeLine.addObserver(game.getConfiguration().getGameTime(), game);
		timeLine.addObserver(game.getConfiguration().getFractionTime(), game);
		timeLine.addObserver(game.getConfiguration().getGameTime(), scoreboardLauncher);
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
