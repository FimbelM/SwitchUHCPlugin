package fr.martinfimbel.switchuhc.scoreboard.blockedexgame;

import fr.martinfimbel.switchuhc.scoreboard.IScoreboardState;

public interface IBDScoreboardState extends IScoreboardState {

	void pause(IBDScoreboardState before);
}
