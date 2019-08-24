package fr.pederobien.uhc.scoreboard;

public class BeforeBorderMoveState extends AbstractScoreboardState {

	public BeforeBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Game");
	}
	
	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
	
	@Override
	public void run() {
		scoreboard.setCurrentState(scoreboard.getAfterBorderMoveState());
	}
}
