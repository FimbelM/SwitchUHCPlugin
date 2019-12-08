package fr.pederobien.uhc.scoreboard;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.IScoreboardMessage;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboardState implements IScoreboardState {
	private List<IScoreboardMessage> entries;
	private String title;
	private TimeTask task;
	private int spaces;

	public AbstractScoreboardState(IScoreboard scoreboard, String title) {
		this.title = title;
		entries = new ArrayList<IScoreboardMessage>();
		task = scoreboard.getTask();
	}

	protected abstract void updateEntries();

	@Override
	public void time(LocalTime time) {

	}

	@Override
	public List<IScoreboardMessage> getEntries() {
		spaces = 0;
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

	protected void addEntryToTranslate(IMessageCode code, String message) {
		addEntry(code, true, null, message);
	}

	protected void addEntryToNotTranslate(String key, String message) {
		addEntry(null, false, key, message);
	}

	protected void addEmptyLine() {
		addEntries(null);
	}

	private void addEntries(IScoreboardMessage message) {
		entries.add(message);
	}

	protected String prepareTime(LocalTime time) {
		String prepareTime = time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
		for (int i = 0; i < spaces; i++) {
			prepareTime += " ";
		}
		spaces++;
		return prepareTime;
	}

	private void addEntry(IMessageCode code, boolean toTranslate, String key, String message) {
		addEntries(new ScoreboardMessage(code, toTranslate, key, message));
	}

	private class ScoreboardMessage implements IScoreboardMessage {
		private IMessageCode code;
		private boolean toTranslate;
		private String key, message;

		public ScoreboardMessage(IMessageCode code, boolean toTranslate, String key, String message) {
			this.code = code;
			this.toTranslate = toTranslate;
			this.key = key;
			this.message = message;
		}

		@Override
		public IMessageCode getCode() {
			return code;
		}

		@Override
		public boolean toTranslate() {
			return toTranslate;
		}

		@Override
		public String getKey() {
			return key;
		}

		@Override
		public String getMessage() {
			return message;
		}
	}
}
