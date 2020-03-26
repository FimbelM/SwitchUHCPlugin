package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import fr.martinfimbel.switchuhc.managers.ScoreboardManager;

public class StopState extends AbstractHungerGameScoreboardState {

	public StopState(IHGScoreboard scoreboard) {
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
