package fr.pederobien.uhc.scoreboard.launcher;

import fr.pederobien.uhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.hungergame.HungerGameScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class HGScoreboardLauncher extends AbstractScoreboardLauncher {
	private IUnmodifiableHungerGameConfiguration configuration;

	public HGScoreboardLauncher(TimeTask task, IUnmodifiableHungerGameConfiguration configuration) {
		super(task);
		this.configuration = configuration;
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new HungerGameScoreboard(task, configuration);
	}
}
