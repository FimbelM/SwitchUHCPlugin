package fr.pederobien.uhc.scoreboard.blockedexgame;

public class StartedState extends AbstractBlockedexScoreboardState {

	public StartedState(IBDScoreboard scoreboard) {
		super(scoreboard, "Blockedex Game");
	}

	@Override
	protected void updateEntries() {

	}

	@Override
	public void pause(IBDScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
