package fr.pederobien.uhc.scoreboard;

public class PauseState extends AbstractScoreboardState {
	private IScoreboardState before;
	
	public PauseState(IScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
		
		updateEntries();
	}
	
	@Override
	void updateEntries() {
		getEntries().clear();
		addEntries("Temps de pause");
		addEntries(prepareTimeOneEscape(task.getPauseTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
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
