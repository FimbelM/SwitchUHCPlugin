package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.managers.ScoreboardManager;

public class StopState extends AbstractHungerGameScoreboardState {

	public StopState(IHGScoreboard scoreboard) {
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
