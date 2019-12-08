package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class PauseState extends AbstractBlockedexScoreboardState {
	private IBDScoreboardState before;

	public PauseState(IBDScoreboard scoreboard) {
		super(scoreboard, "Partie Suspendue");
	}

	@Override
	protected void updateEntries() {
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getTotalTime()));
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_PAUSE_TIME, prepareTime(getTask().getPauseTime()));
	}

	@Override
	public void pause(IBDScoreboardState before) {
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
