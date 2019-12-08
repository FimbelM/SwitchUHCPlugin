package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.managers.BaseManager;

public class StartedState extends AbstractBlockedexScoreboardState {

	public StartedState(IBDScoreboard scoreboard) {
		super(scoreboard, "Blockedex Game");
	}

	@Override
	protected void updateEntries() {
		addEntryToTranslate(MessageCode.SCOREBOARD_BLOCKEDEX_GAME_NORTH_BASE, showBlock(BaseManager.getNorthBaseCenter()));
		addEntryToTranslate(MessageCode.SCOREBOARD_BLOCKEDEX_GAME_SOUTH_BASE, showBlock(BaseManager.getSouthBaseCenter()));
		addEntryToTranslate(MessageCode.SCOREBOARD_BLOCKEDEX_GAME_WEST_BASE, showBlock(BaseManager.getWestBaseCenter()));
		addEntryToTranslate(MessageCode.SCOREBOARD_BLOCKEDEX_GAME_EAST_BASE, showBlock(BaseManager.getEastBaseCenter()));
		addEmptyLine();
		addEntryToTranslate(MessageCode.SCOREBOARD_CURRENT_GAME_TIME, prepareTime(getTask().getDecreasingTime()));
	}

	@Override
	public void pause(IBDScoreboardState before) {
		scoreboard.setCurrentState(scoreboard.getPauseState()).pause(before);
	}

	@Override
	public void stop() {
		scoreboard.setCurrentState(scoreboard.getStopState()).stop();
	}
}
