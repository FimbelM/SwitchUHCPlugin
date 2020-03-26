package fr.martinfimbel.switchuhc.scoreboard.switching;

import fr.martinfimbel.switchuhc.scoreboard.IScoreboardState;

public interface ISWScoreboardState extends IScoreboardState {

	void pause(ISWScoreboardState before);

}
