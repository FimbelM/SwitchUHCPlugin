package fr.martinfimbel.switchuhc.scoreboard.switching;

import java.time.LocalTime;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class BeforeBorderMoveState extends AbstractSwitchGameScoreboardState {
	
	public BeforeBorderMoveState(ISWScoreboard scoreboard) {
		super(scoreboard, "Game");
	}

	@Override
	protected void updateEntries() {
		registerTeam();
		addEntryToTranslate(MessageCode.SCOREBOARD_SWITCH_GAME_BORDER, prepareTime(getTask().getDecreasingTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_TIME_BEFORE_SWITCH, prepareTime(scoreboard.getDecreasingSwitchTime()));
	}

	@Override
	public void pause(ISWScoreboardState before) {
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
