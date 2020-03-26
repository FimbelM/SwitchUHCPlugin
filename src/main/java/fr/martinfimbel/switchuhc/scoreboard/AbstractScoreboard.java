package fr.martinfimbel.switchuhc.scoreboard;

import fr.martinfimbel.switchuhc.managers.ScoreboardManager;
import fr.martinfimbel.switchuhc.task.TimeTask;

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
