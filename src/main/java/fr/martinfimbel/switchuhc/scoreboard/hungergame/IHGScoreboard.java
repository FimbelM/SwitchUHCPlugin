package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;

public interface IHGScoreboard extends IScoreboard {

	IHGScoreboardState getCurrentState();

	IHGScoreboardState setCurrentState(IHGScoreboardState current);

	IHGScoreboardState getInitialState();

	IHGScoreboardState getBeforeBorderMoveState();

	IHGScoreboardState getAfterBorderMoveState();

	IHGScoreboardState getPauseState();

	IHGScoreboardState getStopState();

	IUnmodifiableHungerGameConfiguration getConfiguration();
}
