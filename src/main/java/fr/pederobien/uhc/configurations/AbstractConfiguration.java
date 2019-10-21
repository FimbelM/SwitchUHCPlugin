package fr.pederobien.uhc.configurations;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.TeamsManager;

public abstract class AbstractConfiguration implements IConfiguration {
	private static final Long DEFAULT_SCOREBOARD_REFRESH = new Long(5);
	private static final LocalTime DEFAULT_GAME_TIME = LocalTime.of(2, 0, 0);

	private IGame game;
	private String name;
	private Long scoreboardRefresh;
	private LocalTime gameTime;
	
	protected List<ETeam> teams;
	
	protected AbstractConfiguration(String name) {
		this.name = name;
		teams = new ArrayList<ETeam>();
	}

	@Override
	public IGame getGame() {
		return this.game;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<ETeam> getTeams() {
		return teams;
	}

	@Override
	public boolean addTeam(ETeam team) {
		return teams.add(team);
	}
	
	@Override
	public void removeTeam(ETeam team) {
		teams.remove(team);
	}

	@Override
	public Long getScoreboardRefresh() {
		return scoreboardRefresh == null ? DEFAULT_SCOREBOARD_REFRESH : scoreboardRefresh;
	}

	@Override
	public void setScoreboardRefresh(Long refresh) {
		this.scoreboardRefresh = refresh;
	}

	@Override
	public LocalTime getGameTime() {
		return gameTime == null ? DEFAULT_GAME_TIME : gameTime;
	}

	@Override
	public void setGameTime(LocalTime gameTime) {
		this.gameTime = gameTime;
	}

	@Override
	public void createAssociatedTeams() {
		for (ETeam team : teams)
			TeamsManager.createTeam(team);
	}
	
	@Override
	public List<String> getPlayersRegistered() {
		List<String> players = new ArrayList<String>();
		for (ETeam team : getTeams())
			players.addAll(team.getPlayers());
		return players;
	}
	
	protected void setGame(IGame game) {
		this.game = game;
	}
}
