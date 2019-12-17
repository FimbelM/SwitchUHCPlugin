package fr.pederobien.uhc.configurations;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.ITeam;

public abstract class AbstractConfiguration implements IConfiguration {
	private static final Long DEFAULT_SCOREBOARD_REFRESH = new Long(5);
	private static final LocalTime DEFAULT_GAME_TIME = LocalTime.of(2, 0, 0);

	private IGame game;
	private String name;
	private Long scoreboardRefresh;
	private LocalTime gameTime;

	protected List<ITeam> teams;

	protected AbstractConfiguration(String name) {
		this.name = name;
		teams = new ArrayList<ITeam>();
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
	public List<ITeam> getTeams() {
		return teams;
	}

	@Override
	public ITeam getTeamByName(String name) {
		for (ITeam team : getTeams())
			if (team.getName().equals(name))
				return team;
		return null;
	}

	@Override
	public boolean addTeam(ITeam team) {
		if (teams.contains(team))
			return false;
		return teams.add(team);
	}

	@Override
	public void removeTeam(ITeam team) {
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
	public Stream<String> getPlayersRegistered() {
		List<String> players = new ArrayList<String>();
		for (ITeam team : getTeams())
			players.addAll(team.getPlayers().stream().map(p -> p.getName()).collect(Collectors.toList()));
		return players.stream();
	}

	protected void setGame(IGame game) {
		this.game = game;
	}
}
