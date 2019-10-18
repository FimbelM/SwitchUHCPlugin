package fr.pederobien.uhc.configurations;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.interfaces.IConfiguration;

public abstract class AbstractConfiguration implements IConfiguration {
	private static final Long DEFAULT_SCOREBOARD_REFRESH = new Long(5);
	private static final LocalTime DEFAULT_GAME_TIME = LocalTime.of(2, 0, 0);

	private IGame game;
	private String name;
	private Long scoreboardRefresh;
	private LocalTime gameTime;
	
	protected HashMap<String, ChatColor> teams;

	
	protected AbstractConfiguration(String name) {
		this.name = name;
		teams = new HashMap<String, ChatColor>();
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
	public Map<String, ChatColor> getTeams() {
		return teams;
	}

	@Override
	public void setTeams(HashMap<String, ChatColor> teams) {
		this.teams = teams;
	}

	@Override
	public Long getScoreboardRefresh() {
		return scoreboardRefresh == null ? DEFAULT_SCOREBOARD_REFRESH : scoreboardRefresh;
	}

	@Override
	public void setScoreboardRefresh(Long refresh) {
		this.scoreboardRefresh = refresh;
	}

	public LocalTime getGameTime() {
		return gameTime == null ? DEFAULT_GAME_TIME : gameTime;
	}

	public void setGameTime(LocalTime gameTime) {
		this.gameTime = gameTime;
	}

	protected void setGame(IGame game) {
		this.game = game;
	}
}
