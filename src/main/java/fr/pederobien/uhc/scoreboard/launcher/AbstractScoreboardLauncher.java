package fr.pederobien.uhc.scoreboard.launcher;

import java.time.LocalTime;

import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.scoreboard.IScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboardLauncher extends BukkitRunnable implements IScoreboardLauncher {
	private IScoreboard scoreboard;
	protected TimeTask task;

	public AbstractScoreboardLauncher(TimeTask task) {
		this.task = task;
		scoreboard = getScoreboard();
	}
	
	protected abstract IScoreboard getScoreboard();
	
	@Override
	public void run(long delay, long period) {
		start();
		runTaskTimer(PluginDeposit.plugin, delay, period);
	}

	@Override
	public void run() {
		update();
	}

	@Override
	public void cancel() {
		super.cancel();
		stop();
	}

	@Override
	public void start() {
		scoreboard.start();
	}
	
	@Override
	public void update() {
		scoreboard.update();
	}

	@Override
	public void pause() {
		scoreboard.pause();
	}

	@Override
	public void relaunched() {
		scoreboard.relaunched();
	}
	
	@Override
	public void stop() {
		scoreboard.stop();
	}
	
	@Override
	public void time(LocalTime time) {
		scoreboard.time(time);
	}
}
