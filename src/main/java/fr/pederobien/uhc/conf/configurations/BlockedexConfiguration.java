package fr.pederobien.uhc.conf.configurations;

import java.util.ArrayList;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.game.blockedexgame.BlockedexGame;

public class BlockedexConfiguration extends AbstractConfiguration implements IBlockedexConfiguration {
	public static final BlockedexConfiguration DEFAULT = new BlockedexConfiguration("DefaultConfiguration");
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_DIE = 5;
	private static final Double DEFAULT_STEP_ON_MAX_HEALTH = 1.0;
	private static final Integer DEFAULT_DIAMETER_AREA_ON_PLAYER_RESPAWN = 1000;

	private Integer radiusArea;
	private Double stepHealth;
	private Integer diameterArea;

	public BlockedexConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
		setGame(new BlockedexGame(this));
	}

	@Override
	public Integer getRadiusAreaOnPlayerDie() {
		return radiusArea == null ? DEFAULT_RADIUS_AREA_ON_PLAYER_DIE : radiusArea;
	}

	@Override
	public void setRadiusAreaOnPlayerDie(int radiusArea) {
		this.radiusArea = radiusArea;
	}

	@Override
	public Double getStepOnMaxHealth() {
		return stepHealth == null ? DEFAULT_STEP_ON_MAX_HEALTH : stepHealth;
	}

	@Override
	public void setStepOnMaxHealth(double stepHealth) {
		this.stepHealth = stepHealth;
	}

	@Override
	public Integer getDiameterAreaOnPlayerRespawn() {
		return diameterArea == null ? DEFAULT_DIAMETER_AREA_ON_PLAYER_RESPAWN : diameterArea;
	}

	@Override
	public void setDiameterAreaOnPlayerRespawn(int diameterArea) {
		this.diameterArea = diameterArea;
	}
}
