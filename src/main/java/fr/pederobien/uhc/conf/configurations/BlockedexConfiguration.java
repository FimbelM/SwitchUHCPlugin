package fr.pederobien.uhc.conf.configurations;

import java.util.ArrayList;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.game.blockedexgame.BlockedexGame;

public class BlockedexConfiguration extends AbstractConfiguration {
	public static final BlockedexConfiguration DEFAULT = new BlockedexConfiguration("DefaultConfiguration");
	private static final Integer DEFAULT_RADIUS_AREA_ON_PLAYER_DIE = 5;
	
	private Integer radiusArea;
	
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
}
