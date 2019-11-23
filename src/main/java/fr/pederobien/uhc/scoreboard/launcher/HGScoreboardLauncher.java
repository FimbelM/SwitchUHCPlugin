package fr.pederobien.uhc.scoreboard.launcher;

import fr.pederobien.uhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.hungergame.HungerGameScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class HGScoreboardLauncher extends AbstractScoreboardLauncher<IUnmodifiableHungerGameConfiguration> {

	public HGScoreboardLauncher(TimeTask task, IUnmodifiableHungerGameConfiguration configuration) {
		super(task, configuration);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new HungerGameScoreboard(getTask(), getConfiguration());
	}
}
