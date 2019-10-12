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
	public void initiate() {
		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new BDScoreboardLauncher(taskLauncher.getTask());
		bdPlayerManager = new BlockedexPlayerManager();
		baseManager = new BaseManager(game.getConfiguration().getBases());
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
