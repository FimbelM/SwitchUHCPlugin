package fr.pederobien.uhc.scoreboard.launcher;

import java.util.List;

import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.hungergame.HungerGameScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class HGScoreboardLauncher extends AbstractScoreboardLauncher {
	
	public HGScoreboardLauncher(TimeTask task, List<ETeam> teams) {
		super(task, teams);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new HungerGameScoreboard(task, teams);
	}
}
