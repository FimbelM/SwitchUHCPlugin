package fr.pederobien.uhc.scoreboard;

import java.util.List;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.task.TimeTask;

public class Scoreboard implements IScoreboard {
	private IScoreboardState initial;
	private IScoreboardState before;
	private IScoreboardState after;
	private IScoreboardState pause;
	private IScoreboardState stop;
	private IScoreboardState current;
	
	private TimeTask task;

	public Scoreboard(TimeTask task) {
		this.task = task;
		
		initial = new InitialState(this);
		before = new BeforeBorderMoveState(this);
		after = new AfterBorderMoveState(this);
		pause = new PauseState(this);
		stop = new StopState(this);
		
		current = initial;
	}
	
	@Override
	public IScoreboardState getCurrentState() {
		return current;
	}

	@Override
	public IScoreboardState setCurrentState(IScoreboardState current) {
		return this.current = current;
	}
	
	@Override
	public IScoreboardState getInitialState() {
		return initial;
	}

	@Override
	public IScoreboardState getBeforeBorderMoveState() {
		return before;
	}

	@Override
	public IScoreboardState getAfterBorderMoveState() {
		return after;
	}

	@Override
	public IScoreboardState getPauseState() {
		return pause;
	}
	
	@Override
	public IScoreboardState getStopState() {
		return stop;
	}
	
	@Override
	public TimeTask getTask() {
		return task;
	}

	@Override
	public void run() {
		current.run();
	}
	
	@Override
	public void timeChanged(TimeTask task) {
		current.timeChanged(task);
	}

	@Override
	public List<String> getEntries() {
		return current.getEntries();
	}

	@Override
	public String getTitle() {
		return current.getTitle();
	}

	@Override
	public void start() {
		current.start();
	}

	@Override
	public void pause(IScoreboardState before) {
		current.pause(before);
	}

	@Override
	public void relaunched() {
		current.relaunched();
	}
	
	@Override
	public void stop() {
		current.stop();
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		current.onPlayerJoin(event);
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		current.onPlayerDie(event);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		current.onPlayerQuit(event);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		current.onPlayerRespawn(event);
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		current.onPlayerMove(event);
	}
}
