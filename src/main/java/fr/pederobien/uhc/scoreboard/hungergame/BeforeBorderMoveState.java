package fr.pederobien.uhc.scoreboard.hungergame;

import java.time.LocalTime;

public class BeforeBorderMoveState extends AbstractHungerGameScoreboardState {

	public BeforeBorderMoveState(IHGScoreboard scoreboard) {
		super(scoreboard, "Game");
	}

	@Override
	protected void updateEntries() {
		addEntries("Bordure", prepareTime(getTask().getDecreasingTime()));
		addEntries("Temps", prepareTime(getTask().getTotalTime()));
	}

	@Override
	public void pause(IHGScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}

	@Override
	public void time(LocalTime time) {
		scoreboard.setCurrentState(scoreboard.getAfterBorderMoveState());
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
