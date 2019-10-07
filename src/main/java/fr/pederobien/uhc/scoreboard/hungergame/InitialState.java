package fr.pederobien.uhc.scoreboard.hungergame;

public class InitialState extends AbstractHungerGameScoreboardState {

	public InitialState(IHGScoreboard scoreboard) {
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
