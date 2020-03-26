package fr.martinfimbel.switchuhc.scoreboard.switching;

import java.time.LocalTime;
import java.util.List;

import fr.martinfimbel.switchuhc.interfaces.IScoreboardMessage;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;
import fr.martinfimbel.switchuhc.scoreboard.AbstractScoreboard;
import fr.martinfimbel.switchuhc.task.TimeTask;

public class SwitchGameScoreboard extends AbstractScoreboard implements ISWScoreboard {
	private ISWScoreboardState initial;
	private ISWScoreboardState before;
	private ISWScoreboardState after;
	private ISWScoreboardState pause;
	private ISWScoreboardState stop;
	private ISWScoreboardState current;
	private IUnmodifiableSwitchConfiguration configuration;

	public SwitchGameScoreboard(TimeTask task, IUnmodifiableSwitchConfiguration configuration) {
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
	public void time(LocalTime time) {
		current.time(time);
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
	public void update() {
		// TODO Auto-generated method stub

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
	public TimeTask getTask() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ISWScoreboardState getCurrentState() {
		return current;
	}

	@Override
	public ISWScoreboardState setCurrentState(ISWScoreboardState current) {
		return this.current = current;
	}

	@Override
	public ISWScoreboardState getInitialState() {
		return initial;
	}

	@Override
	public ISWScoreboardState getBeforeBorderMoveState() {
		return before;
	}

	@Override
	public ISWScoreboardState getAfterBorderMoveState() {
		return after;
	}

	@Override
	public ISWScoreboardState getPauseState() {
		return pause;
	}

	@Override
	public ISWScoreboardState getStopState() {
		return stop;
	}

	@Override
	public IUnmodifiableSwitchConfiguration getConfiguration() {
		return configuration;
	}
}

