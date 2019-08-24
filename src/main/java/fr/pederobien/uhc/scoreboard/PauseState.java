package fr.pederobien.uhc.scoreboard;

public class PauseState extends AbstractScoreboardState {
	private IScoreboardState before;
	
	public PauseState(IScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}
	
	@Override
	public void pause(IScoreboardState before) {
		this.before = before;
	}
	
	@Override
	public void relaunched() {
		scoreboard.setCurrentState(before);
	}
}
