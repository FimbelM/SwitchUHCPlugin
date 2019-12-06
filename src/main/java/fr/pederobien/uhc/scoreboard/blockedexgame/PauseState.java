package fr.pederobien.uhc.scoreboard.blockedexgame;

public class PauseState extends AbstractBlockedexScoreboardState {
	private IBDScoreboardState before;

	public PauseState(IBDScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}

	@Override
	protected void updateEntries() {
		addEntries("Jeu", prepareTime(getTask().getTotalTime()));
		addEntries("Pause", prepareTime(getTask().getPauseTime()));
	}

	@Override
	public void pause(IBDScoreboardState before) {
		this.before = before;
	}

	@Override
	public void relaunched() {
		scoreboard.setCurrentState(before);
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
