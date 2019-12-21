package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;

public interface IConfiguration extends IUnmodifiableConfiguration, IResetable {

	boolean addTeam(ITeam team);

	void removeTeam(ITeam team);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
}
