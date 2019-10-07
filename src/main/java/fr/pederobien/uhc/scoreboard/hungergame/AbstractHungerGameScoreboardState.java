package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.scoreboard.AbstractScoreboardState;
import fr.pederobien.uhc.scoreboard.ScoreboardStateException;

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
