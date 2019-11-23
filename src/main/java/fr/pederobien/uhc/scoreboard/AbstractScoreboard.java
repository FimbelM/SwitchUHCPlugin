package fr.pederobien.uhc.scoreboard;

import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboard implements IScoreboard {
	private TimeTask task;

	protected AbstractScoreboard(TimeTask task) {
		this.task = task;
	}

	@Override
	public void update() {
		ScoreboardManager.setPlayersScoreboardWithCurrentLocation(this);
	}

	@Override
	public TimeTask getTask() {
		return task;
	}
}
