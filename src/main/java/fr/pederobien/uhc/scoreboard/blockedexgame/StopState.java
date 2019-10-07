package fr.pederobien.uhc.scoreboard.blockedexgame;

import fr.pederobien.uhc.managers.ScoreboardManager;

public class StopState extends AbstractBlockedexScoreboardState {

	public StopState(IBDScoreboard scoreboard) {
		super(scoreboard, "Partie terminée");
	}

	@Override
	protected void updateEntries() {

	}
	
	@Override
	public void stop() {
		ScoreboardManager.removePlayersScoreboard();
	}
}
