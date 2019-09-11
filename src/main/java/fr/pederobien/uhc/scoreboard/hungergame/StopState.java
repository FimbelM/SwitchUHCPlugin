package fr.pederobien.uhc.scoreboard.hungergame;

import fr.pederobien.uhc.managers.ScoreboardManager;

public class StopState extends AbstractScoreboardState {

	public StopState(IScoreboard scoreboard) {
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
