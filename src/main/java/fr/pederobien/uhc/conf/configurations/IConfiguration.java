package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;

public interface IConfiguration<T> {

	T getGame();

	void setGame(T game);

	Spawn getSpawn();

	void setSpawn(Spawn spawn);

	String getName();

	void setName(String name);

	List<Team> getTeams();

	void setTeams(List<Team> teams);

}
