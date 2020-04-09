package fr.martinfimbel.switchuhc.scoreboard.switching;

import java.time.LocalTime;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class BeforeBorderMoveState extends AbstractSwitchGameScoreboardState {
	int remainingTime, switchPeriod;
	boolean switchafterbordermoves = true;

	public BeforeBorderMoveState(ISWScoreboard scoreboard) {
		super(scoreboard, "Game");
	}

	private boolean getSwitchafterbordermoves() {
		String YN = scoreboard.getConfiguration().getSwitchAfterBorderMoves();
		if (YN.equalsIgnoreCase("N"))
			switchafterbordermoves = false;
		return switchafterbordermoves;
	}

	private int getSwitchPeriod() {
		return switchPeriod = scoreboard.getDecreasingSwitchTime().toSecondOfDay();
	}

	private int getRemainingTime() {
		return remainingTime = getTask().getDecreasingTime().toSecondOfDay();
	}

	@Override
	protected void updateEntries() {
		registerTeam();
		addEntryToTranslate(MessageCode.SCOREBOARD_SWITCH_GAME_BORDER, prepareTime(getTask().getDecreasingTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
		if (!getSwitchafterbordermoves()) {
			if (getRemainingTime() > getSwitchPeriod()) {
				addEntryToTranslate(MessageCode.SCOREBOARD_TIME_BEFORE_SWITCH,
						prepareTime(scoreboard.getDecreasingSwitchTime()));
			} else {
				addEntryToTranslate(MessageCode.SCOREBOARD_TIME_BEFORE_SWITCH_DEACTIVATED, "");
			}
		}
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
