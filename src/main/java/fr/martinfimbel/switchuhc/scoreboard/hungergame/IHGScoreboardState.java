package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import fr.martinfimbel.switchuhc.scoreboard.IScoreboardState;

public interface IHGScoreboardState extends IScoreboardState {

	void pause(IHGScoreboardState before);
}
