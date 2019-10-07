package fr.pederobien.uhc.scoreboard.blockedexgame;

import java.util.List;

import fr.pederobien.uhc.scoreboard.AbstractScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class BlockedexScoreboard extends AbstractScoreboard implements IBDScoreboard {
	private IBDScoreboardState initial;
	private IBDScoreboardState started;
	private IBDScoreboardState pause;
	private IBDScoreboardState stop;
	private IBDScoreboardState current;

	private TimeTask task;

	public BlockedexScoreboard(TimeTask task) {
		this.task = task;

		initial = new InitialState(this);
		started = new StartedState(this);
		pause = new PauseState(this);
		stop = new StopState(this);

		current = initial;
	}

	@Override
	public IBDScoreboardState getCurrentState() {
		return current;
	}

	@Override
	public IBDScoreboardState setCurrentState(IBDScoreboardState current) {
		return this.current = current;
	}

	@Override
	public IBDScoreboardState getInitialState() {
		return initial;
	}
	
	@Override
	public IBDScoreboardState getStartedState() {
		return started;
	}

	@Override
	public IBDScoreboardState getPauseState() {
		return pause;
	}

	@Override
	public IBDScoreboardState getStopState() {
		return stop;
	}

	@Override
	public String getTitle() {
		return current.getTitle();
	}

	@Override
	public List<String> getEntries() {
		return current.getEntries();
	}

	@Override
	public void start() {
		current.start();
	}

	@Override
	public void pause() {
		current.pause(current);
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
	public void time() {
		current.time();
	}

	@Override
	public TimeTask getTask() {
		return task;
	}
}
