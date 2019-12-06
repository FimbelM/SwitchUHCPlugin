package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.scoreboard.IScoreboard;

public interface IBDScoreboard extends IScoreboard {

	IBDScoreboardState getCurrentState();

	IBDScoreboardState setCurrentState(IBDScoreboardState current);

	IBDScoreboardState getInitialState();

	IBDScoreboardState getStartedState();

	IBDScoreboardState getPauseState();

	IBDScoreboardState getStopState();

	IUnmodifiableBlockedexConfiguration getConfiguration();
}
