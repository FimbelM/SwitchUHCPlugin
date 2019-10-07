package fr.pederobien.uhc.scoreboard.launcher;

import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.blockedexgame.BlockedexScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class BDScoreboardLauncher extends AbstractScoreboardLauncher {

	public BDScoreboardLauncher(TimeTask task) {
		super(task);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new BlockedexScoreboard(task);
	}
}
