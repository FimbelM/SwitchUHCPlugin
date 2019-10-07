package fr.pederobien.uhc.scoreboard.hungergame;

public class PauseState extends AbstractHungerGameScoreboardState {
	private IHGScoreboardState before;

	public PauseState(IHGScoreboard scoreboard) {
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
	public void pause(IHGScoreboardState before) {
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
