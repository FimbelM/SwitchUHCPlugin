package fr.pederobien.uhc.scoreboard;

import fr.pederobien.uhc.managers.ScoreboardManager;

public class StopState extends AbstractScoreboardState {

	public StopState(IScoreboard scoreboard) {
		super(scoreboard, "Partie terminée");
	}
	
	@Override
	void updateEntries() {
		
	}
	
	@Override
	public void stop() {
		ScoreboardManager.removePlayersScoreboard();
	}
}
