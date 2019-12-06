package fr.pederobien.uhc.task;

import java.time.LocalTime;

import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.PluginDeposit;

public class TaskLauncher extends BukkitRunnable implements ITaskLauncher {
	private TimeTask task;

	public TaskLauncher(LocalTime gameTime) {
		this.task = new TimeTask(gameTime);
	}

	public TaskLauncher(String gameTime) {
		this.task = new TimeTask(gameTime);
	}

	@Override
	public void run(long delay, long period) {
		runTaskTimer(PluginDeposit.plugin, delay, period);
	}

	@Override
	public void run() {
		task.run();
	}

	public void pause() {
		task.pause();
	}

	@Override
	public void cancel() {
		super.cancel();
		task.cancel();
	}

	@Override
	public void relaunched() {
		task.relaunched();
	}

	@Override
	public TimeTask getTask() {
		return task;
	}
}
