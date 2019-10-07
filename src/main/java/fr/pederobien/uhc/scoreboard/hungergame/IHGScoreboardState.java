package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.scoreboard.IScoreboardState;

public interface IHGScoreboardState extends IScoreboardState {

	void pause(IHGScoreboardState before);
}
