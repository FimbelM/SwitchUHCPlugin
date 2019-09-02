package fr.pederobien.uhc.conf.configurations;

import java.time.LocalTime;
import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.managers.WorldManager;

public class HungerGameConfiguration extends AbstractConfiguration {
	public static final HungerGameConfiguration DEFAULT = new HungerGameConfiguration("Default configuration");
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private static final Double DEFAULT_INITIAL_BORDER_SIZE = new Double(2000);
	private static final Double DEFAULT_FINAL_BORDER_SIZE = new Double(10);
	private static final LocalTime DEFAULT_GAME_TIME = LocalTime.of(2, 0, 0);
	private static final LocalTime DEFAULT_FRACTION_TIME = LocalTime.of(0, 45, 0);
	private static final Long DEFAULT_SCOREBOARD_REFRESH = new Long(5);
	private Block borderCenter;
	private Double initialBorderSize, finalBorderSize;
	private LocalTime gameTime;
	private LocalTime fractionTime;
	private Long scoreboardRefresh;

	public HungerGameConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
	}

	public Block getBorderCenter() {
		return borderCenter == null ? DEFAULT_CENTER : borderCenter;
	}

	public void setBorderCenter(Block borderCenter) {
		this.borderCenter = borderCenter;
	}

	public void setBorderCenter(String x, String y, String z) {
		borderCenter = WorldManager.getBlockAt(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
	}

	public Double getInitialBorderSize() {
		return initialBorderSize == null ? DEFAULT_INITIAL_BORDER_SIZE : initialBorderSize;
	}

	public void setInitialBorderSize(double initialBorderSize) {
		this.initialBorderSize = initialBorderSize;
	}

	public Double getFinalBorderSize() {
		return finalBorderSize == null ? DEFAULT_FINAL_BORDER_SIZE : finalBorderSize;
	}

	public void setFinalBorderSize(double finalBorderSize) {
		this.finalBorderSize = finalBorderSize;
	}

	public LocalTime getGameTime() {
		return gameTime == null ? DEFAULT_GAME_TIME : gameTime;
	}

	public void setGameTime(LocalTime gameTime) {
		this.gameTime = gameTime;
	}

	public LocalTime getFractionTime() {
		return fractionTime == null ? DEFAULT_FRACTION_TIME : fractionTime;
	}

	public void setFractionTime(LocalTime fractionTime) {
		this.fractionTime = fractionTime;
	}

	public Long getScoreboardRefresh() {
		return scoreboardRefresh == null ? DEFAULT_SCOREBOARD_REFRESH : scoreboardRefresh;
	}

	public void setScoreboardRefresh(long scoreboardRefresh) {
		this.scoreboardRefresh = scoreboardRefresh;
	}
}
