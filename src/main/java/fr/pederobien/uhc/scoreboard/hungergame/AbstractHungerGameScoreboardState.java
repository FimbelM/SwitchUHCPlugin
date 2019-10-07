package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.scoreboard.AbstractScoreboardState;
import fr.pederobien.uhc.scoreboard.ScoreboardStateException;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractHungerGameScoreboardState extends AbstractScoreboardState implements IHGScoreboardState {
	protected IHGScoreboard scoreboard;
	protected static TimeTask task;

	public AbstractHungerGameScoreboardState(IHGScoreboard scoreboard, String title) {
		super(title);
		this.scoreboard = scoreboard;
		task = scoreboard.getTask();
	}

	@Override
	public void pause(IHGScoreboardState before) {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}
}
