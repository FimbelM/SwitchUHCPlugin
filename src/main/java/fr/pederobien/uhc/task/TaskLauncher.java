package fr.pederobien.uhc.task;

import java.time.LocalTime;

import org.bukkit.scheduler.BukkitRunnable;

public class TaskLauncher extends BukkitRunnable {
	private TimeTask task;

	public TaskLauncher(LocalTime gameTime, LocalTime fractionTime) {
		this.task = new TimeTask(gameTime, fractionTime);
	}
	
	public TaskLauncher(String gameTime, String fractionTime) {
		this.task = new TimeTask(gameTime, fractionTime);
	}

	@Override
	public void run() {
		task.run();
	}

	public void pause() {
		task.pause();
	}
	
	@Override
	public synchronized void cancel() throws IllegalStateException {
		super.cancel();
		task.cancel();
	}
	
	public void relaunched() {
		task.relaunched();
	}

	public TimeTask getTask() {
		return task;
	}
}
