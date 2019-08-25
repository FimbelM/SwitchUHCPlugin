package fr.pederobien.uhc.scoreboard;

public class BeforeBorderMoveState extends AbstractScoreboardState {

	public BeforeBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Game");		
	}
	
	@Override
	void updateEntries() {
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeOneEscape(task.getDecreasingTime()));
		addEntries("Déplacement bordure dans");
	}
	
	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
	
	@Override
	public void run() {
		scoreboard.setCurrentState(scoreboard.getAfterBorderMoveState());
	}
	
	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
