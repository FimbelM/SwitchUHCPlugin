package fr.pederobien.uhc.scoreboard;

public interface IScoreboard {
	
	IScoreboardState getCurrentState();
	
	IScoreboardState setCurrentState(IScoreboardState current);
	
	IScoreboardState getBeforeBorderMoveState();
	
	IScoreboardState getAfterBorderMoveState();
	
	IScoreboardState getPauseState();
	
	IScoreboardState getStopState();

}
