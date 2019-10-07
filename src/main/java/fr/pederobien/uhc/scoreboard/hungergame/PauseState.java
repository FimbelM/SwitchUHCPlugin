package fr.pederobien.uhc.scoreboard.hungergame;

public class PauseState extends AbstractHungerGameScoreboardState {
	private IScoreboardState before;

	public PauseState(IHGScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}

	@Override
	protected void updateEntries() {
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeOneEscape(task.getPauseTime()));
		addEntries("Temps de pause");
	}

	@Override
	public void pause(IScoreboardState before) {
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
