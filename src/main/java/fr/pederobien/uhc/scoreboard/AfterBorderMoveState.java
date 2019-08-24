package fr.pederobien.uhc.scoreboard;

public class AfterBorderMoveState extends AbstractScoreboardState {

	public AfterBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Brace Yourself");
	}
	
	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
}
