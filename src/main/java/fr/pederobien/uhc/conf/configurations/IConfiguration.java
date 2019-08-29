package fr.pederobien.uhc.conf.configurations;

import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.game.IGameBase;
import fr.pederobien.uhc.game.IGameBaseState;

public interface IConfiguration {

	IGameBase<IGameBaseState> getGame();
	
	void setGame(IGameBase<IGameBaseState> game);

	Spawn getSpawn();

	void setSpawn(Spawn spawn);

	String getName();

	void setName(String name);

	List<Team> getTeams();

	void setTeams(List<Team> teams);
	
	void persiste();
}
