package fr.pederobien.uhc.scoreboard.hungergame;

import java.util.List;

import fr.pederobien.uhc.scoreboard.AbstractScoreboard;
import fr.pederobien.uhc.task.TimeTask;

public class HungerGameScoreboard extends AbstractScoreboard implements IHGScoreboard {
	private IScoreboardState initial;
	private IScoreboardState before;
	private IScoreboardState after;
	private IScoreboardState pause;
	private IScoreboardState stop;
	private IScoreboardState current;
	
	private TimeTask task;
	
	public HungerGameScoreboard(TimeTask task) {
		this.task = task;
		
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
	public void time() {
		current.time();
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
}
