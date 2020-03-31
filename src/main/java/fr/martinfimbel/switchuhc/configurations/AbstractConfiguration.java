package fr.martinfimbel.switchuhc.configurations;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ITeam;

public abstract class AbstractConfiguration implements IConfiguration {
	private static final Long DEFAULT_SCOREBOARD_REFRESH = new Long(5);
	private static final LocalTime DEFAULT_GAME_TIME = LocalTime.of(2, 0, 0);

	private IGame game;
	private String name;
	private Long scoreboardRefresh;
	private LocalTime gameTime;

	private List<ITeam> teams, notEmptyTeams;

	protected AbstractConfiguration(String name) {
		this.name = name;
		teams = new ArrayList<ITeam>();
		notEmptyTeams = new ArrayList<ITeam>();
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
	public List<ITeam> getNotEmptyTeams() {
		return notEmptyTeams;
	}

	@Override
	public String showTeams() {
		String teams = "";
		for (ITeam team : getTeams())
			teams += team + "\n";
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
	public void addTeam(ITeam team) {
		teams.add(team);
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
	public void reset() {
		gameTime = null;
		scoreboardRefresh = null;
		teams.clear();
	}

	@Override
	public Stream<String> getPlayersRegistered() {
		List<String> players = new ArrayList<String>();
		for (ITeam team : getTeams())
			players.addAll(team.getPlayers().stream().map(p -> p.getName()).collect(Collectors.toList()));
		return players.stream();
	}

	@Override
	public void prepareTeam() {
		for (ITeam team : teams)
			if (!team.getPlayers().isEmpty())
				notEmptyTeams.add(team);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Name : " + getName() + "\n");
		builder.append("ScoreboardRefresh : " + getScoreboardRefresh() + "\n");
		builder.append("Moving Border Time : " + showTime(getGameTime()) + "\n");
		builder.append("Teams :\n" + showTeams());
		return builder.toString();
	}

	public String showTime(LocalTime time) {
		return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	}

	public String showBlock(Block block) {
		return "X=" + block.getX() + " Y=" + block.getY() + " Z=" + block.getZ();
	}

	protected void setGame(IGame game) {
		this.game = game;
	}
}
