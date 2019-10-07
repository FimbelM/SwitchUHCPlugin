package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.scoreboard.launcher.BDScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractBlockedexState {

	public InitialState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public void initiate() {
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new BDScoreboardLauncher(taskLauncher.getTask());
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
