package fr.pederobien.uhc.scoreboard;

public class BeforeBorderMoveState extends AbstractScoreboardState {

	public BeforeBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Game");		
	}
	
	@Override
	void updateEntries() {
		addEntries(scoreboard.getChatColor() + prepareTimeNoEscape(task.getTotalTime()));
		addEntries(scoreboard.getChatColor() + "Temps de jeu");
		addEntries(scoreboard.getChatColor() + prepareTimeOneEscape(task.getDecreasingTime()));
		addEntries(scoreboard.getChatColor() + "Déplacement bordure dans");
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
