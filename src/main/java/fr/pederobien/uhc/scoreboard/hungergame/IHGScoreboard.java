package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public interface IHGScoreboard extends IScoreboard {
	
	IHGScoreboardState getCurrentState();
	
	IHGScoreboardState setCurrentState(IHGScoreboardState current);
	
	IHGScoreboardState getInitialState();
	
	IHGScoreboardState getBeforeBorderMoveState();
	
	IHGScoreboardState getAfterBorderMoveState();
	
	IHGScoreboardState getPauseState();
	
	IHGScoreboardState getStopState();
		
	TimeTask getTask();
}
