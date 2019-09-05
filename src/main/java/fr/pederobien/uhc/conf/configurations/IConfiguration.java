package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.game.IGame;

public interface IConfiguration {

	IGame getGame();

	String getName();

	void setName(String name);

	List<Team> getTeams();

	void setTeams(List<Team> teams);

}
