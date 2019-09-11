package fr.pederobien.uhc.scoreboard;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.observer.IObsTimeLine;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboardLauncher extends BukkitRunnable implements IObsTimeLine {
	private List<IScoreboard> scoreboards;
	protected TimeTask task;

	public AbstractScoreboardLauncher(TimeTask task) {
		this.task = task;
		scoreboards = new ArrayList<IScoreboard>();
		initialize();
	}
	
	protected abstract void initialize();

	@Override
	public void run() {
		update();
	}

	@Override
	public synchronized void cancel() throws IllegalStateException {
		super.cancel();
		stop();
	}

	public void start() {
		for (IScoreboard sc : scoreboards)
			sc.start();
	}
	
	public void update() {
		for (IScoreboard sc : scoreboards)
			sc.update();
	}

	public void pause() {
		for (IScoreboard sc : scoreboards)
			sc.pause();
	}

	public void relaunched() {
		for (IScoreboard sc : scoreboards)
			sc.relaunched();
	}
	
	public void stop() {
		for (IScoreboard sc : scoreboards)
			sc.stop();
	}
	
	@Override
	public void time() {
		for (IScoreboard sc : scoreboards)
			sc.time();
	}
	
	protected List<IScoreboard> getScoreboards() {
		return scoreboards;
	}
}
