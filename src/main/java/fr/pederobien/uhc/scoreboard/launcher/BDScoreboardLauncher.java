package fr.pederobien.uhc.scoreboard.launcher;

import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.blockedexgame.BlockedexScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class BDScoreboardLauncher extends AbstractScoreboardLauncher<IUnmodifiableBlockedexConfiguration> {
	
	public BDScoreboardLauncher(TimeTask task, IUnmodifiableBlockedexConfiguration configuration) {
		super(task, configuration);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new BlockedexScoreboard(getTask(), getConfiguration());
	}
}
