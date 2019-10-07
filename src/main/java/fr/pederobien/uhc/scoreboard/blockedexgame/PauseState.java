package fr.pederobien.uhc.scoreboard.blockedexgame;

public class PauseState extends AbstractBlockedexScoreboardState {
	private IBDScoreboardState before;
	
	public PauseState(IBDScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}

	@Override
	protected void updateEntries() {
		addEntries(prepareTimeNoEscape(getTask().getTotalTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeOneEscape(getTask().getPauseTime()));
		addEntries("Temps de pause");
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
