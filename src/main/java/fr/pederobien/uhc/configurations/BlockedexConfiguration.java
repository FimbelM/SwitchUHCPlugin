package fr.pederobien.uhc.configurations;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.game.blockedexgame.BlockedexGame;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;
import fr.pederobien.uhc.managers.BaseManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class BlockedexConfiguration extends AbstractConfiguration implements IBlockedexConfiguration {
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_DIE = 5;
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_KILL = 5;
	private static final Double DEFAULT_STEP_ON_MAX_HEALTH = 1.0;
	private static final Integer DEFAULT_DIAMETER_AREA_ON_PLAYER_RESPAWN = 1000;
	private static final Integer DEFAULT_BASE_FROM_SPAWN_DISTANCE = 1000;
	private static final IUnmodifiableBase DEFAULT_BASE = BaseManager.getBaseByName(IBase.DEFAULT.getName());
	public static final BlockedexConfiguration DEFAULT = new BlockedexConfiguration("DefaultConfiguration");

	private Integer radiusAreaOnPlayerDie;
	private Integer radiusAreaOnPlayerKill;
	private Double stepHealth;
	private Integer diameterArea;
	private IUnmodifiableBase northBase, southBase, westBase, eastBase;
	private Integer baseFromSpawnDistance;

	public BlockedexConfiguration(String name) {
		super(name);
		setGame(new BlockedexGame(this));
		
		for (ChatColor color : getNorthBase().getChests().values())
			teams.put(TeamsManager.getColorName(color), color);
		for (ChatColor color : getSouthBase().getChests().values())
			teams.put(TeamsManager.getColorName(color), color);
		for (ChatColor color : getWestBase().getChests().values())
			teams.put(TeamsManager.getColorName(color), color);
		for (ChatColor color : getEastBase().getChests().values())
			teams.put(TeamsManager.getColorName(color), color);
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
	public Double getStepOnMaxHealth() {
		return stepHealth == null ? DEFAULT_STEP_ON_MAX_HEALTH : stepHealth;
	}

	@Override
	public Double getDoubleStepOnMaxHealth() {
		return getStepOnMaxHealth() * 2;
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
	public IUnmodifiableBase getNorthBase() {
		return northBase == null ? DEFAULT_BASE : northBase;
	}

	@Override
	public IUnmodifiableBase getSouthBase() {
		return southBase == null ? DEFAULT_BASE : southBase;
	}

	@Override
	public IUnmodifiableBase getWestBase() {
		return westBase == null ? DEFAULT_BASE : westBase;
	}

	@Override
	public IUnmodifiableBase getEastBase() {
		return eastBase == null ? DEFAULT_BASE : eastBase;
	}

	@Override
	public void setNorthBase(IUnmodifiableBase northBase) {
		this.northBase = northBase;
	}

	@Override
	public void setSouthBase(IUnmodifiableBase southBase) {
		this.southBase = southBase;
	}

	@Override
	public void setWestBase(IUnmodifiableBase westBase) {
		this.westBase = westBase;
	}

	@Override
	public void setEastBase(IUnmodifiableBase eastBase) {
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
