package fr.pederobien.uhc.scoreboard;

import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.observer.IObsTimeLine;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboardLauncher extends BukkitRunnable implements IObsTimeLine {
	private IScoreboard scoreboard;
	protected TimeTask task;

	public AbstractScoreboardLauncher(TimeTask task) {
		this.task = task;
		scoreboard = getScoreboard();
	}
	
	protected abstract IScoreboard getScoreboard();

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
		scoreboard.start();
	}
	
	public void update() {
		scoreboard.update();
	}

	public void pause() {
		scoreboard.pause();
	}

	public void relaunched() {
		scoreboard.relaunched();
	}
	
	public void stop() {
		scoreboard.stop();
	}
	
	@Override
	public void time() {
		scoreboard.time();
	}
}
