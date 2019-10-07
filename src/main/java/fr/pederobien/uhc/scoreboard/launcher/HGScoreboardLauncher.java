package fr.pederobien.uhc.scoreboard.launcher;

import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.hungergame.HungerGameScoreboard;
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
