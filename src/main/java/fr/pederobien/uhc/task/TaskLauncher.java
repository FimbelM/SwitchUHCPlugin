package fr.pederobien.uhc.task;

import java.time.LocalTime;

import org.bukkit.scheduler.BukkitRunnable;

public class TaskLauncher extends BukkitRunnable {
	private TimeTask task;

	public TaskLauncher(LocalTime gameTime, LocalTime fractionTime, int increment) {
		this.task = new TimeTask(gameTime, fractionTime, increment);
	}
	
	public TaskLauncher(String gameTime, String fractionTime, int increment) {
		this.task = new TimeTask(gameTime, fractionTime, increment);
	}

	@Override
	public void run() {
		task.run();
	}

	public void pause() {
		task.ToPause();
	}

	public TimeTask getTask() {
		return task;
	}
}
