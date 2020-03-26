package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import fr.martinfimbel.switchuhc.scoreboard.AbstractScoreboardState;
import fr.martinfimbel.switchuhc.scoreboard.ScoreboardStateException;

public abstract class AbstractHungerGameScoreboardState extends AbstractScoreboardState implements IHGScoreboardState {
	protected IHGScoreboard scoreboard;

	public AbstractHungerGameScoreboardState(IHGScoreboard scoreboard, String title) {
		super(scoreboard, title);
		this.scoreboard = scoreboard;
	}

	@Override
	public void pause(IHGScoreboardState before) {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}
}
