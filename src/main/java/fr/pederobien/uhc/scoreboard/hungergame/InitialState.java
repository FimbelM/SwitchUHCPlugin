package fr.pederobien.uhc.scoreboard.hungergame;

public class InitialState extends AbstractScoreboardState {

	public InitialState(IScoreboard scoreboard) {
		super(scoreboard, "");
	}

	@Override
	protected void updateEntries() {
		
	}
	
	@Override
	public void start() {
		scoreboard.setCurrentState(scoreboard.getBeforeBorderMoveState());
	}
}
