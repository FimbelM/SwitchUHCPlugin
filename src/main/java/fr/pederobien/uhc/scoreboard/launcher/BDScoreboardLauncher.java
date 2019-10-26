package fr.pederobien.uhc.scoreboard.launcher;

import java.util.List;

import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.blockedexgame.BlockedexScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class BDScoreboardLauncher extends AbstractScoreboardLauncher {

	public BDScoreboardLauncher(TimeTask task, List<ETeam> teams) {
		super(task, teams);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new BlockedexScoreboard(task, teams);
	}
}
