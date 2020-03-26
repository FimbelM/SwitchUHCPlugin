package fr.martinfimbel.switchuhc.scoreboard.switching;

public class InitialState extends AbstractSwitchGameScoreboardState {
	
	public InitialState(ISWScoreboard scoreboard) {
		super(scoreboard, "Initial");
	}

	@Override
	protected void updateEntries() {

	}

	@Override
	public void start() {
		scoreboard.setCurrentState(scoreboard.getBeforeBorderMoveState());
	}
}
