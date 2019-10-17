package fr.pederobien.uhc.configurations;

import java.time.LocalTime;
import java.util.List;

import org.bukkit.scoreboard.Team;

public interface IConfiguration extends IUnmodifiableConfiguration {
	
	void setName(String name);

	void setTeams(List<Team> teams);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
}
