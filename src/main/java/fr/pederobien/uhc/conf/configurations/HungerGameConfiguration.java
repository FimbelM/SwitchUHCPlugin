package fr.pederobien.uhc.conf.configurations;

import java.time.LocalTime;
import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;
import fr.pederobien.uhc.game.hungergame.HungerGame;
import fr.pederobien.uhc.managers.WorldManager;

public class HungerGameConfiguration extends AbstractConfiguration<HungerGame, HungerGamePersistence> {
	public static final HungerGameConfiguration DEFAULT = new HungerGameConfiguration("Default configuration");
	private Block borderCenter;
	private double initialBorderSize, finalBorderSize;
	private LocalTime gameTime;
	private LocalTime fractionTime;
	private long scoreboardRefresh;
	private HungerGamePersistence persistence;
	
	static {
		DEFAULT.setBorderCenter(WorldManager.getHighestBlockYAt(0, 0));
		DEFAULT.setInitialBorderSize(2000);
		DEFAULT.setFinalBorderSize(10);
		DEFAULT.setFractionTime(LocalTime.of(0, 45, 0));
		DEFAULT.setGameTime(LocalTime.of(2, 0, 0));
		DEFAULT.setName("Default configuration");
		DEFAULT.setSpawn(Spawn.DEFAULT);
		DEFAULT.setScoreboardRefresh(5);
	}
	
	public HungerGameConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
		persistence = new HungerGamePersistence(this);
	}
	
	@Override
	public HungerGamePersistence getPersistence() {
		return persistence;
	}

	public Block getBorderCenter() {
		return borderCenter;
	}

	public void setBorderCenter(Block borderCenter) {
		this.borderCenter = borderCenter;
	}

	public double getInitialBorderSize() {
		return initialBorderSize;
	}

	public void setInitialBorderSize(double initialBorderSize) {
		this.initialBorderSize = initialBorderSize;
	}
	
	public double getFinalBorderSize() {
		return finalBorderSize;
	}
	
	public void setFinalBorderSize(double finalBorderSize) {
		this.finalBorderSize = finalBorderSize;
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
