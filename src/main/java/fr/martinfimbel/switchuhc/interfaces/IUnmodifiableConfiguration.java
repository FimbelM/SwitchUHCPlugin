package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import fr.martinfimbel.switchuhc.game.IGame;

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
