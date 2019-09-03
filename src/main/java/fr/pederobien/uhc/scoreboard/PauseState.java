package fr.pederobien.uhc.scoreboard;

public class PauseState extends AbstractScoreboardState {
	private IScoreboardState before;
	
	public PauseState(IScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}
	
	@Override
	void updateEntries() {
		addEntries(scoreboard.getChatColor() + prepareTimeNoEscape(task.getTotalTime()));
		addEntries(scoreboard.getChatColor() + "Temps de jeu");
		addEntries(scoreboard.getChatColor() + prepareTimeOneEscape(task.getPauseTime()));
		addEntries(scoreboard.getChatColor() + "Temps de pause");
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
