package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.managers.BaseManager;

public class StartedState extends AbstractBlockedexScoreboardState {

	public StartedState(IBDScoreboard scoreboard) {
		super(scoreboard, "Blockedex Game");
	}

	@Override
	protected void updateEntries() {
		addEntries("East", showBlock(BaseManager.getEastBaseCenter()));
		addEntries("West", showBlock(BaseManager.getWestBaseCenter()));
		addEntries("South", showBlock(BaseManager.getSouthBaseCenter()));
		addEntries("North", showBlock(BaseManager.getNorthBaseCenter()));
		addEmptyLine();
		addEntries("Temps", prepareTime(getTask().getDecreasingTime()));
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
