package fr.martinfimbel.switchuhc.scoreboard.blockedexgame;

import java.time.LocalTime;
import java.util.List;

import fr.martinfimbel.switchuhc.interfaces.IScoreboardMessage;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.AbstractScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class BlockedexScoreboard extends AbstractScoreboard implements IBDScoreboard {
	private IBDScoreboardState initial;
	private IBDScoreboardState started;
	private IBDScoreboardState pause;
	private IBDScoreboardState stop;
	private IBDScoreboardState current;

	private IUnmodifiableBlockedexConfiguration configuration;

	public BlockedexScoreboard(TimeTask task, IUnmodifiableBlockedexConfiguration configuration) {
		super(task);

		this.configuration = configuration;
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
	public IUnmodifiableBlockedexConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public String getTitle() {
		return current.getTitle();
	}

	@Override
	public List<IScoreboardMessage> getEntries() {
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
	public void time(LocalTime time) {
		current.time(time);
	}
}
