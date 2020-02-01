package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;

public interface IConfiguration extends IUnmodifiableConfiguration, IResetable {

	void addTeam(ITeam team);

	void removeTeam(ITeam team);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
}
