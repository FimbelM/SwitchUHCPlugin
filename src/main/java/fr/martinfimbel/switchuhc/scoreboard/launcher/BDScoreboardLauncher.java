package fr.martinfimbel.switchuhc.scoreboard.launcher;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;
import fr.martinfimbel.switchuhc.scoreboard.blockedexgame.BlockedexScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class BDScoreboardLauncher extends AbstractScoreboardLauncher<IUnmodifiableBlockedexConfiguration> {

	public BDScoreboardLauncher(TimeTask task, IUnmodifiableBlockedexConfiguration configuration) {
		super(task, configuration);
	}

	@Override
	protected IScoreboard getScoreboard() {
		return new BlockedexScoreboard(getTask(), getConfiguration());
	}
}
