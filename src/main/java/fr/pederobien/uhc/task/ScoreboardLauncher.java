package fr.pederobien.uhc.task;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.observer.IObsTimeLine;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.scoreboard.Scoreboard;

public class ScoreboardLauncher extends BukkitRunnable implements IObsTimeLine {
	private List<IScoreboard> scoreboards;

	public ScoreboardLauncher(TimeTask task) {
		scoreboards = new ArrayList<IScoreboard>();
		for (Player player : PlayerManager.getPlayers())
			scoreboards.add(new Scoreboard(player, task));
	}

	@Override
	public void run() {
		for (IScoreboard sc : scoreboards)
			sc.update();
	}

	@Override
	public synchronized void cancel() throws IllegalStateException {
		super.cancel();
		for (IScoreboard sc : scoreboards)
			sc.stop();
	}

	public void start() {
		for (IScoreboard sc : scoreboards)
			sc.start();
	}

	public void pause() {
		for (IScoreboard sc : scoreboards)
			sc.pause(sc.getCurrentState());
	}

	public void relaunched() {
		for (IScoreboard sc : scoreboards)
			sc.relaunched();
	}
	
	@Override
	public void time() {
		for (IScoreboard sc : scoreboards)
			sc.time();
	}
}
