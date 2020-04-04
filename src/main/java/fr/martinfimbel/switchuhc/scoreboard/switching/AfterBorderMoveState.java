package fr.martinfimbel.switchuhc.scoreboard.switching;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class AfterBorderMoveState extends AbstractSwitchGameScoreboardState {
	public AfterBorderMoveState(ISWScoreboard scoreboard) {
		super(scoreboard, "BRACE YOURSELF: BORDER MOVES");
	}

	@Override
	protected void updateEntries() {
		registerTeam();
		addEntryToTranslate(MessageCode.SCOREBOARD_SWITCH_GAME_BORDER,
				"" + WorldManager.getCurrentDiameter().intValue() / 2);
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
		
		String YN = scoreboard.getConfiguration().getSwitchAfterBorderMoves();
		if(YN.equals("Y"))
				addEntryToTranslate(MessageCode.SCOREBOARD_TIME_BEFORE_SWITCH, prepareTime(scoreboard.getDecreasingSwitchTime()));
		else
		addEntryToTranslate(MessageCode.SCOREBOARD_TIME_BEFORE_SWITCH_DEACTIVATED, "");
	}

	@Override
	public void pause(ISWScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
