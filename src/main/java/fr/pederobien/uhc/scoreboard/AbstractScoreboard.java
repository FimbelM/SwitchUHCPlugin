package fr.pederobien.uhc.scoreboard;

import fr.pederobien.uhc.managers.ScoreboardManager;

public abstract class AbstractScoreboard implements IScoreboard {

	@Override
	public void update() {
		ScoreboardManager.setPlayersScoreboardWithCurrentLocation(this);
	}
}
