package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;
import java.util.List;

import fr.pederobien.uhc.managers.ETeam;

public interface IConfiguration extends IUnmodifiableConfiguration {
	
	void setName(String name);

	void setTeams(List<ETeam> teams);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
	
	void createAssociatedTeams();
}
