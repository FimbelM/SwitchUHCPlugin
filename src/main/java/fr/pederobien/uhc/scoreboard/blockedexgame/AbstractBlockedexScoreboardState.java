package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.scoreboard.AbstractScoreboardState;
import fr.pederobien.uhc.scoreboard.ScoreboardStateException;

public abstract class AbstractBlockedexScoreboardState extends AbstractScoreboardState implements IBDScoreboardState {
	protected IBDScoreboard scoreboard;

	public AbstractBlockedexScoreboardState(IBDScoreboard scoreboard, String title) {
		super(scoreboard, title);
	}

	@Override
	public void pause(IBDScoreboardState before) {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}
}
