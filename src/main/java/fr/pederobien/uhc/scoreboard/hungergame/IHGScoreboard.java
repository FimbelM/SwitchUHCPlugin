package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public interface IHGScoreboard extends IScoreboard {
	
	IScoreboardState getCurrentState();
	
	IScoreboardState setCurrentState(IScoreboardState current);
	
	IScoreboardState getInitialState();
	
	IScoreboardState getBeforeBorderMoveState();
	
	IScoreboardState getAfterBorderMoveState();
	
	IScoreboardState getPauseState();
	
	IScoreboardState getStopState();
		
	TimeTask getTask();
}