package fr.pederobien.uhc.scoreboard.hungergame;

public class PauseState extends AbstractScoreboardState {
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
		addEntries(getShowingLocation());
		addEntries("Coordonnées X/Y/Z");
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
