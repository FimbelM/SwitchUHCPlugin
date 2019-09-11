package fr.pederobien.uhc.scoreboard.hungergame;

public class BeforeBorderMoveState extends AbstractScoreboardState {

	public BeforeBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Game");		
	}
	
	@Override
	protected void updateEntries() {
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeOneEscape(task.getDecreasingTime()));
		addEntries("Déplacement bordure dans");
		addEntries(getShowingLocation());
		addEntries("Coordonnées X/Y/Z");
	}
	
	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
	
	@Override
	public void time() {
		scoreboard.setCurrentState(scoreboard.getAfterBorderMoveState());
	}
	
	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
