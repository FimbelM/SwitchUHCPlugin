package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;
import java.util.List;

import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.managers.ETeam;

public interface IUnmodifiableConfiguration extends IUnmodifiableName {
	
	IGame getGame();
	
	List<ETeam> getTeams();
	
	Long getScoreboardRefresh();
	
	LocalTime getGameTime();
	
	List<String> getPlayersRegistered();
}
