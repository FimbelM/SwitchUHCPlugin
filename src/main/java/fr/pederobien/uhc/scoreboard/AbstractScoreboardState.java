package fr.pederobien.uhc.scoreboard;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboardState implements IScoreboardState {
	private List<String> entries;
	private String title;
	private TimeTask task;

	public AbstractScoreboardState(IScoreboard scoreboard, String title) {
		this.title = title;
		entries = new ArrayList<String>();
		task = scoreboard.getTask();
	}

	protected abstract void updateEntries();

	@Override
	public void time() {

	}

	@Override
	public List<String> getEntries() {
		entries.clear();
		updateEntries();
		return entries;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void start() {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}

	@Override
	public void relaunched() {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}

	@Override
	public void stop() {
		throw new ScoreboardStateException("This method cannot be called by this state");
	}

	protected TimeTask getTask() {
		return task;
	}

	protected void addEntries(String score) {
		entries.add(score);
	}

	protected String prepareTimeNoEscape(LocalTime time) {
		return prepareTime(time, 0);
	}

	protected String prepareTimeOneEscape(LocalTime time) {
		return prepareTime(time, 1);
	}

	protected String prepareTimeTwoEscapes(LocalTime time) {
		return prepareTime(time, 2);
	}

	protected String prepareTimeThreeEscapes(LocalTime time) {
		return prepareTime(time, 3);
	}

	protected String prepareTime(LocalTime time, int numberOfSpace) {
		String prepareTime = time.getHour() + "h" + time.getMinute() + "m" + time.getSecond() + "s";
		for (int i = 0; i < numberOfSpace; i++) {
			prepareTime += " ";
		}
		return prepareTime;
	}
}