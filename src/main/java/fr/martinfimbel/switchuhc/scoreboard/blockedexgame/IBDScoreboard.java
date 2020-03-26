package fr.martinfimbel.switchuhc.scoreboard.blockedexgame;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;

public interface IBDScoreboard extends IScoreboard {

	IBDScoreboardState getCurrentState();

	IBDScoreboardState setCurrentState(IBDScoreboardState current);

	IBDScoreboardState getInitialState();

	IBDScoreboardState getStartedState();

	IBDScoreboardState getPauseState();

	IBDScoreboardState getStopState();

	IUnmodifiableBlockedexConfiguration getConfiguration();
}
