package fr.pederobien.uhc.conf.configurations;

import java.util.ArrayList;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.game.blockedexgame.BlockedexGame;

public class BlockedexConfiguration extends AbstractConfiguration {
	public static final BlockedexConfiguration DEFAULT = new BlockedexConfiguration("DefaultConfiguration");
	
	public BlockedexConfiguration(String name) {
		setName(name);
		setTeams(new ArrayList<Team>());
		setGame(new BlockedexGame(this));
	}
}
