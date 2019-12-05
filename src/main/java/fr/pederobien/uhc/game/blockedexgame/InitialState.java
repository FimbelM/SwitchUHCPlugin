package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
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
		if (!BaseManager.setBlockedexGameCurrentConfiguration(game.getConfiguration())) {
			message = MessageCode.BAD_BASES_CONFIGURATION;
			return false;
		}

		taskLauncher = new TaskLauncher(game.getConfiguration().getGameTime());
		timeLine = new TimeLine(taskLauncher.getTask());
		scoreboardLauncher = new BDScoreboardLauncher(taskLauncher.getTask(), game.getConfiguration());
		bdPlayerManager = new BlockedexPlayerManager(game.getConfiguration());

		return true;
	}

	@Override
	public void start() {
		game.setCurrentState(game.getStart()).start();
	}
}
