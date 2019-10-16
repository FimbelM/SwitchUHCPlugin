package fr.pederobien.uhc.scoreboard;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboardState implements IScoreboardState {
	private List<String> entries;
	private String title;
	private TimeTask task;
	private int spaces;

	public AbstractScoreboardState(IScoreboard scoreboard, String title) {
		this.title = title;
		entries = new ArrayList<String>();
		task = scoreboard.getTask();
	}

	protected abstract void updateEntries();

	@Override
	public void time(LocalTime time) {

	}

	@Override
	public List<String> getEntries() {
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

	protected void addEntries(String score) {
		entries.add(score);
	}

	protected void addEntries(String key, String value) {
		addEntries(ChatColor.GOLD + key + ": " + ChatColor.DARK_GREEN + value);
	}

	protected void addEmptyLine() {
		addEntries(ScoreboardManager.emptyLine());
	}

	protected String prepareTime(LocalTime time) {
		String prepareTime = time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
		for (int i = 0; i < spaces; i++) {
			prepareTime += " ";
		}
		spaces++;
		return prepareTime;
	}
}
