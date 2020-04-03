package fr.martinfimbel.switchuhc.scoreboard.switching;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class PauseState extends AbstractSwitchGameScoreboardState {
	private ISWScoreboardState before;

	public PauseState(ISWScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}

	@Override
	protected void updateEntries() {
		registerTeam();
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_PAUSE_TIME, prepareTime(getTask().getPauseTime()));
	}

	@Override
	public void pause(ISWScoreboardState before) {
		this.before = before;
	}

	@Override
	public void relaunched() {
		scoreboard.setCurrentState(before);
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
