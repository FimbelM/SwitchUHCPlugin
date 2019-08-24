package fr.pederobien.uhc.scoreboard;

public class BeforeBorderMoveState extends AbstractScoreboardState {

	public BeforeBorderMoveState(IScoreboard scoreboard) {
		super(scoreboard, "Game");
		
		addEntries("Déplacement bordure dans");
		addEntries(prepareTimeOneEscape(task.getDecreasingTime()));
		addEntries("Temps de jeu");
		addEntries(prepareTimeNoEscape(task.getTotalTime()));
	}
	
	@Override
	public void pause(IScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}
	
	@Override
	public void run() {
		scoreboard.setCurrentState(scoreboard.getAfterBorderMoveState());
	}
}
