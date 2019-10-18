package fr.pederobien.uhc.configurations;

import java.util.ArrayList;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.game.blockedexgame.BlockedexGame;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class BlockedexConfiguration extends AbstractConfiguration implements IBlockedexConfiguration {
	public static final BlockedexConfiguration DEFAULT = new BlockedexConfiguration("DefaultConfiguration");
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_DIE = 5;
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_KILL = 5;
	private static final Double DEFAULT_STEP_ON_MAX_HEALTH = 1.0;
	private static final Integer DEFAULT_DIAMETER_AREA_ON_PLAYER_RESPAWN = 1000;
	private static final Integer DEFAULT_BASE_FROM_SPAWN_DISTANCE = 1000;

	private Integer radiusAreaOnPlayerDie;
	private Integer radiusAreaOnPlayerKill;
	private Double stepHealth;
	private Integer diameterArea;
	private String northBase, southBase, westBase, eastBase;
	private Integer baseFromSpawnDistance;

	public BlockedexConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
		setGame(new BlockedexGame(this));
	}

	@Override
	public Integer getRadiusAreaOnPlayerDie() {
		return radiusAreaOnPlayerDie == null ? DEFAULT_RADIUS_AREA_ON_PLAYER_DIE : radiusAreaOnPlayerDie;
	}

	@Override
	public void setRadiusAreaOnPlayerDie(int radiusAreaOnPlayerDie) {
		this.radiusAreaOnPlayerDie = radiusAreaOnPlayerDie;
	}

	@Override
	public Double getOneHalfHeart() {
		return stepHealth == null ? DEFAULT_STEP_ON_MAX_HEALTH : stepHealth;
	}

	@Override
	public Double getOneHeart() {
		return getOneHalfHeart() * 2;
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

	@Override
	public Integer getRadiusAreaOnPlayerKill() {
		return radiusAreaOnPlayerKill == null ? DEFAULT_RADIUS_AREA_ON_PLAYER_KILL : radiusAreaOnPlayerKill;
	}

	@Override
	public void setRadiusAreaOnPlayerKill(int radiusAreaOnPlayerKill) {
		this.radiusAreaOnPlayerKill = radiusAreaOnPlayerKill;
	}

	@Override
	public String getNorthBase() {
		return northBase;
	}

	@Override
	public String getSouthBase() {
		return southBase;
	}

	@Override
	public String getWestBase() {
		return westBase;
	}

	@Override
	public String getEastBase() {
		return eastBase;
	}

	@Override
	public void setNorthBase(String northBase) {
		this.northBase = northBase;
	}

	@Override
	public void setSouthBase(String southBase) {
		this.southBase = southBase;
	}

	@Override
	public void setWestBase(String westBase) {
		this.westBase = westBase;
	}

	@Override
	public void setEastBase(String eastBase) {
		this.eastBase = eastBase;
	}
	
	@Override
	public Integer getBaseFromSpawnDistance() {
		return baseFromSpawnDistance == null ? DEFAULT_BASE_FROM_SPAWN_DISTANCE : baseFromSpawnDistance;
	}
	
	@Override
	public void setBaseFromSpawnDistance(int baseFromSpawnDistance) {
		this.baseFromSpawnDistance = baseFromSpawnDistance;
	}
}
