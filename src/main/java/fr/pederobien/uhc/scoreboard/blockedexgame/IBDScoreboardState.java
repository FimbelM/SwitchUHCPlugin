package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.scoreboard.IScoreboardState;

public interface IBDScoreboardState extends IScoreboardState {

	void pause(IBDScoreboardState before);
}
