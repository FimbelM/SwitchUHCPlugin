package fr.martinfimbel.switchuhc.scoreboard.blockedexgame;

import fr.martinfimbel.switchuhc.managers.ScoreboardManager;

public class StopState extends AbstractBlockedexScoreboardState {

	public StopState(IBDScoreboard scoreboard) {
		super(scoreboard, "Partie termin�e");
	}

	@Override
	protected void updateEntries() {

	}

	@Override
	public void stop() {
		ScoreboardManager.removePlayersScoreboard();
	}
}
