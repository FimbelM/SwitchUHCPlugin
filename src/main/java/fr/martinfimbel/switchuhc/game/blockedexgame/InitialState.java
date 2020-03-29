package fr.martinfimbel.switchuhc.game.blockedexgame;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.managers.BaseManager;
import fr.martinfimbel.switchuhc.managers.BlockedexPlayerManager;
import fr.martinfimbel.switchuhc.scoreboard.launcher.BDScoreboardLauncher;
import fr.martinfimbel.switchuhc.task.TaskLauncher;
import fr.martinfimbel.switchuhc.task.TimeLine;

public class InitialState extends AbstractBlockedexState {

	public InitialState(IBlockedexGame game) {
		super(game);
	}

	@Override
	public boolean initiate() {
		if (!BaseManager.setBlockedexGameCurrentConfiguration(getConfiguration())) {
			message = MessageCode.BAD_BASES_CONFIGURATION;
			return false;
		}

		taskLauncher = new TaskLauncher(getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new BDScoreboardLauncher(taskLauncher.getTask(), getConfiguration(), game);
		bdPlayerManager = new BlockedexPlayerManager(getConfiguration());

		return true;
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
