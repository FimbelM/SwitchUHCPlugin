package fr.pederobien.uhc.task;

import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.scoreboard.IScoreboard;

public class ScoreboardLauncher extends BukkitRunnable {
	private IScoreboard scoreboard;
	
	public ScoreboardLauncher(IScoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	
	@Override
	public void run() {
		scoreboard.getEntries();
		ScoreboardManager.setPlayersScoreboardWithCurrentLocation(scoreboard.getTitle(), scoreboard.getEntries());
	}
}
