package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.scoreboard.AbstractScoreboardLauncher;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class HGScoreboardLauncher extends AbstractScoreboardLauncher {
	
	public HGScoreboardLauncher(TimeTask task) {
		super(task);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new HungerGameScoreboard(task);
	}
}
