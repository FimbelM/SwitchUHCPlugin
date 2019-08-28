package fr.pederobien.uhc.conf.configurations;

import java.time.LocalTime;
import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.game.hungergame.HungerGame;
import fr.pederobien.uhc.managers.WorldManager;

public class HungerGameConfiguration extends AbstractConfiguration<HungerGame> {
	public static final HungerGameConfiguration DEFAULT = new HungerGameConfiguration("Default configuration");
	private Block borderCenter;
	private double borderSize;
	private LocalTime gameTime;
	private LocalTime fractionTime;
	private long scoreboardRefresh;
	
	static {
		DEFAULT.setBorderCenter(WorldManager.getHighestBlockYAt(0, 0));
		DEFAULT.setBorderSize(2000);
		DEFAULT.setFractionTime(LocalTime.of(0, 45, 0));
		DEFAULT.setGameTime(LocalTime.of(2, 0, 0));
		DEFAULT.setName("Default configuration");
		DEFAULT.setSpawn(Spawn.DEFAULT);
		DEFAULT.setScoreboardRefresh(5);
	}
	
	public HungerGameConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
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
	
	public long getScoreboardRefresh() {
		return scoreboardRefresh;
	}

	public void setScoreboardRefresh(long scoreboardRefresh) {
		this.scoreboardRefresh = scoreboardRefresh;
	}
}
