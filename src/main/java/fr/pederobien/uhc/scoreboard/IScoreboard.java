package fr.pederobien.uhc.scoreboard;

import fr.pederobien.uhc.task.TimeTask;

public interface IScoreboard {
	
	IScoreboardState getCurrentState();
	
	IScoreboardState setCurrentState(IScoreboardState current);
	
	IScoreboardState getBeforeBorderMoveState();
	
	IScoreboardState getAfterBorderMoveState();
	
	IScoreboardState getPauseState();
	
	IScoreboardState getStopState();
	
	TimeTask getTask();
}
