package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class PauseState extends AbstractHungerGameScoreboardState {
	private IHGScoreboardState before;

	public PauseState(IHGScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}

	@Override
	protected void updateEntries() {
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_PAUSE_TIME, prepareTime(getTask().getPauseTime()));
	}

	@Override
	public void pause(IHGScoreboardState before) {
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
