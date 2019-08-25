package fr.pederobien.uhc.scoreboard;

public class InitialState extends AbstractScoreboardState {

	public InitialState(IScoreboard scoreboard) {
		super(scoreboard, "");
	}

	@Override
	void updateEntries() {
		
	}
	
	@Override
	public void start() {
		scoreboard.setCurrentState(scoreboard.getBeforeBorderMoveState());
	}
}
