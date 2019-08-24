package fr.pederobien.uhc.conf;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.scoreboard.Team;

public class Configuration {
	public static final Configuration DEFAULT = new Configuration();
	private Location spawnLocation;
	private Block borderCenter;
	private double borderSize;
	private String spawnName;
	private LocalTime gameTime;
	private LocalTime fractionTime;
	private List<Team> teams;
	
	public Configuration() {
		setTeams(new ArrayList<Team>());
	}
	
	public Location getSpawnLocation() {
		return spawnLocation;
	}
	
	public void setSpawnLocation(Location spawnLocation) {
		this.spawnLocation = spawnLocation;
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

	public String getSpawnName() {
		return spawnName;
	}

	public void setSpawnName(String spawnName) {
		this.spawnName = spawnName;
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
}
