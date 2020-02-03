package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import fr.pederobien.uhc.game.IGame;

public interface IUnmodifiableConfiguration extends IUnmodifiableName {

	IGame getGame();

	List<ITeam> getTeams();

	List<ITeam> getNotEmptyTeams();

	String showTeams();

	ITeam getTeamByName(String name);

	Long getScoreboardRefresh();

	LocalTime getGameTime();

	Stream<String> getPlayersRegistered();

	void prepareTeam();
}
