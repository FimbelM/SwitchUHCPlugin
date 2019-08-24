package fr.pederobien.uhc.scoreboard;

public interface IScoreboard {
	
	IScoreboardState getCurrentState();
	
	void setCurrentState(IScoreboardState current);
	
	IScoreboardState getBeforeBorderMoveState();
	
	IScoreboardState getAfterBorderMoveState();
	
	IScoreboardState getPauseState();

}
