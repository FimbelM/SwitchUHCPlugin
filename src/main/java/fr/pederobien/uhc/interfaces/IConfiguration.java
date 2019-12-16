package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;

import fr.pederobien.uhc.managers.EColor;

public interface IConfiguration extends IUnmodifiableConfiguration, IName {

	boolean addTeam(EColor team);

	void removeTeam(EColor team);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
}
