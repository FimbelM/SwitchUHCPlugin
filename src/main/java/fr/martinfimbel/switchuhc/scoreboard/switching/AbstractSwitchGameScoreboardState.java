package fr.martinfimbel.switchuhc.scoreboard.switching;

import fr.martinfimbel.switchuhc.scoreboard.AbstractScoreboardState;
import fr.martinfimbel.switchuhc.scoreboard.ScoreboardStateException;

public abstract class AbstractSwitchGameScoreboardState extends AbstractScoreboardState implements ISWScoreboardState {
	protected ISWScoreboard scoreboard;

	public AbstractSwitchGameScoreboardState(ISWScoreboard scoreboard, String title) {
		super(scoreboard, title);
		this.scoreboard = scoreboard;
	}

	@Override
	public void pause(ISWScoreboardState before) {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}
}
