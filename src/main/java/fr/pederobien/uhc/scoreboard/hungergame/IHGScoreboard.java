package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.pederobien.uhc.scoreboard.IScoreboard;

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
