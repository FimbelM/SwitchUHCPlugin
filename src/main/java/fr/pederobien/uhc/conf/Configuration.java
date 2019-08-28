package fr.pederobien.uhc.conf;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.configurations.AbstractConfiguration;
import fr.pederobien.uhc.game.hungergame.IGameState;
import fr.pederobien.uhc.managers.WorldManager;

public class Configuration extends AbstractConfiguration<IGameState> {
	public static final Configuration DEFAULT = new Configuration();
	private Spawn spawn;
	private Block borderCenter;
	private double borderSize;
	private String name;
	private LocalTime gameTime;
	private LocalTime fractionTime;
	private long scoreboardRefresh;
	private List<Team> teams;

	static {
		DEFAULT.setBorderCenter(WorldManager.getHighestBlockYAt(0, 0));
		DEFAULT.setBorderSize(2000);
		DEFAULT.setFractionTime(LocalTime.of(0, 45, 0));
		DEFAULT.setGameTime(LocalTime.of(2, 0, 0));
		DEFAULT.setName("Default configuration");
		DEFAULT.setSpawn(Spawn.DEFAULT);
		DEFAULT.setScoreboardRefresh(5);
	}

	public Configuration() {
		this("Default configuration");
	}

	public Configuration(String name) {
		setTeams(new ArrayList<Team>());
	}

	public void setSpawn(Spawn spawn) {
		this.spawn = spawn;
	}

	public Spawn getSpawn() {
		return spawn;
	}

	public Block getBorderCenter() {
		return borderCenter;
	}

	public void setBorderCenter(Block borderCenter) {
		this.borderCenter = borderCenter;
	}

	public double getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(double borderSize) {
		this.borderSize = borderSize;
	}

	public LocalTime getGameTime() {
		return gameTime;
	}

	public void setGameTime(LocalTime gameTime) {
		this.gameTime = gameTime;
	}

	public LocalTime getFractionTime() {
		return fractionTime;
	}

	public void setFractionTime(LocalTime fractionTime) {
		this.fractionTime = fractionTime;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getScoreboardRefresh() {
		return scoreboardRefresh;
	}
	
	public void setScoreboardRefresh(long scoreboardRefresh) {
		this.scoreboardRefresh = scoreboardRefresh;
	}
}
