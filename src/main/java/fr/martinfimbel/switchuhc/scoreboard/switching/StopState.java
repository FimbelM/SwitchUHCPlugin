package fr.martinfimbel.switchuhc.scoreboard.switching;

import fr.martinfimbel.switchuhc.managers.ScoreboardManager;

public class StopState extends AbstractSwitchGameScoreboardState {

	public StopState(ISWScoreboard scoreboard) {
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
