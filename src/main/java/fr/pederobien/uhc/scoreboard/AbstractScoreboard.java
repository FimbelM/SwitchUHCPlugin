package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.ScoreboardManager;
import fr.pederobien.uhc.task.TimeTask;

public abstract class AbstractScoreboard implements IScoreboard {
	private TimeTask task;
	private List<ETeam> teams;
	
	protected AbstractScoreboard(TimeTask task, List<ETeam> teams) {
		this.task = task;
		this.teams = teams;
	}
	
	@Override
	public void update() {
		ScoreboardManager.setPlayersScoreboardWithCurrentLocation(this);
	}
	
	@Override
	public TimeTask getTask() {
		return task;
	}
	
	@Override
	public List<ETeam> getTeams() {
		return teams;
	}
}
