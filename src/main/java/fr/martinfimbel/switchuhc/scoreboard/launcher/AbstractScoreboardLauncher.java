package fr.martinfimbel.switchuhc.scoreboard.launcher;

import java.time.LocalTime;

import org.bukkit.scheduler.BukkitRunnable;

import fr.martinfimbel.switchuhc.SwitchPluginDeposit;
import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public abstract class AbstractScoreboardLauncher<T extends IUnmodifiableConfiguration, U extends IGame>	extends BukkitRunnable implements IScoreboardLauncher {
	private IScoreboard scoreboard;
	private T configuration;
	private U game;
	private TimeTask task;
	
	public AbstractScoreboardLauncher(TimeTask task, T configuration, U game) {
		this.task = task;
		this.configuration = configuration;
		this.game = game;
		scoreboard = getScoreboard();
	}

	protected abstract IScoreboard getScoreboard();

	@Override
	public void run(long delay, long period) {
		start();
		runTaskTimer(SwitchPluginDeposit.plugin, delay, period);
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

	protected TimeTask getTask() {
		return task;
	}

	protected T getConfiguration() {
		return configuration;
	}
	
	protected U getGame() {
		return game;
	}
}
