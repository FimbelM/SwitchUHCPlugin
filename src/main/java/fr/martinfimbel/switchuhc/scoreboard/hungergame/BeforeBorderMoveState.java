package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import java.time.LocalTime;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class BeforeBorderMoveState extends AbstractHungerGameScoreboardState {

	public BeforeBorderMoveState(IHGScoreboard scoreboard) {
		super(scoreboard, "Game");
	}

	@Override
	protected void updateEntries() {
		addEntryToTranslate(MessageCode.SCOREBOARD_HUNGER_GAME_BORDER, prepareTime(getTask().getDecreasingTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
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
