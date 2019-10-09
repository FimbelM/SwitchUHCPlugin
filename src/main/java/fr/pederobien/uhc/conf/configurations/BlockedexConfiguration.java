package fr.pederobien.uhc.conf.configurations;

import java.util.ArrayList;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.game.blockedexgame.BlockedexGame;

public class BlockedexConfiguration extends AbstractConfiguration {
	public static final BlockedexConfiguration DEFAULT = new BlockedexConfiguration("DefaultConfiguration");
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_DIE = 5;
	private static final Double DEFAULT_STEP_ON_MAX_HEALTH = 1.0;
	
	private Integer radiusArea;
	private Double stepHealth;
	
	public BlockedexConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
		setGame(new BlockedexGame(this));
	}
	
	public Integer getAreaRadiusOnPlayerDie() {
		return radiusArea == null ? DEFAULT_RADIUS_AREA_ON_PLAYER_DIE : radiusArea;
	}
	
	public void setAreaRadiusOnPlayerDie(int radiusArea) {
		this.radiusArea = radiusArea;
	}
	
	public Double getStepOnMaxHealth() {
		return stepHealth == null ? DEFAULT_STEP_ON_MAX_HEALTH : stepHealth;
	}
	
	public void setStepOnMaxHealth(double stepHealth) {
		this.stepHealth = stepHealth;
	}
}
