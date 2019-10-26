package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.managers.BaseManager;
import fr.pederobien.uhc.managers.BlockedexPlayerManager;
import fr.pederobien.uhc.scoreboard.launcher.BDScoreboardLauncher;
import fr.pederobien.uhc.task.TaskLauncher;
import fr.pederobien.uhc.task.TimeLine;

public class InitialState extends AbstractBlockedexState {

	public InitialState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public boolean initiate() {
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new BDScoreboardLauncher(taskLauncher.getTask(), game.getConfiguration().getTeams());
		bdPlayerManager = new BlockedexPlayerManager();

		if (BaseManager.setBlockedexGameCurrentConfiguration(game.getConfiguration()))
			return true;

		message = "One or more bases (north, south, west, east) or not defined";
		return false;
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
