package fr.martinfimbel.switchuhc.scoreboard.switching;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;

public interface ISWScoreboard extends IScoreboard {

	ISWScoreboardState getBeforeBorderMoveState();

	ISWScoreboardState getCurrentState();

	ISWScoreboardState setCurrentState(ISWScoreboardState current);

	ISWScoreboardState getInitialState();

	ISWScoreboardState getAfterBorderMoveState();

	ISWScoreboardState getPauseState();

	ISWScoreboardState getStopState();

	IUnmodifiableSwitchConfiguration getConfiguration();
}
