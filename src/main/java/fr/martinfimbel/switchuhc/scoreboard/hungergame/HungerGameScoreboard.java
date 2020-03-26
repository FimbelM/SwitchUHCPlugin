package fr.martinfimbel.switchuhc.scoreboard.hungergame;

import java.time.LocalTime;
import java.util.List;

import fr.martinfimbel.switchuhc.interfaces.IScoreboardMessage;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.AbstractScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class HungerGameScoreboard extends AbstractScoreboard implements IHGScoreboard {
	private IHGScoreboardState initial;
	private IHGScoreboardState before;
	private IHGScoreboardState after;
	private IHGScoreboardState pause;
	private IHGScoreboardState stop;
	private IHGScoreboardState current;
	private IUnmodifiableHungerGameConfiguration configuration;

	public HungerGameScoreboard(TimeTask task, IUnmodifiableHungerGameConfiguration configuration) {
		super(task);

		this.configuration = configuration;
		initial = new InitialState(this);
		before = new BeforeBorderMoveState(this);
		after = new AfterBorderMoveState(this);
		pause = new PauseState(this);
		stop = new StopState(this);

		current = initial;
	}

	@Override
	public void stop() {
		current.stop();
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
	public void time(LocalTime time) {
		current.time(time);
	}

	@Override
	public IHGScoreboardState getCurrentState() {
		return current;
	}

	@Override
	public IHGScoreboardState setCurrentState(IHGScoreboardState current) {
		return this.current = current;
	}

	@Override
	public IHGScoreboardState getInitialState() {
		return initial;
	}

	@Override
	public IHGScoreboardState getBeforeBorderMoveState() {
		return before;
	}

	@Override
	public IHGScoreboardState getAfterBorderMoveState() {
		return after;
	}

	@Override
	public IHGScoreboardState getPauseState() {
		return pause;
	}

	@Override
	public IHGScoreboardState getStopState() {
		return stop;
	}

	@Override
	public IUnmodifiableHungerGameConfiguration getConfiguration() {
		return configuration;
	}
}
