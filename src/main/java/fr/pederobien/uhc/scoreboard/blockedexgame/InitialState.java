package fr.pederobien.uhc.scoreboard.blockedexgame;

public class InitialState extends AbstractBlockedexScoreboardState {

	public InitialState(IBDScoreboard scoreboard) {
		super(scoreboard, "Initial");
	}

	@Override
	protected void updateEntries() {

	}
	
	@Override
	public void start() {
		scoreboard.setCurrentState(scoreboard.getStartedState());

	}
}
