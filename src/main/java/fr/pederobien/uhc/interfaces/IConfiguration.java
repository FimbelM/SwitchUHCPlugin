package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;

import fr.pederobien.uhc.managers.ETeam;

public interface IConfiguration extends IUnmodifiableConfiguration, IName {

	boolean addTeam(ETeam team);

	void removeTeam(ETeam team);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
}
