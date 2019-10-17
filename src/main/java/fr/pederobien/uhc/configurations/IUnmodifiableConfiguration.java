package fr.pederobien.uhc.configurations;

import java.time.LocalTime;
import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.interfaces.IName;

public interface IUnmodifiableConfiguration extends IName {
	
	IGame getGame();
	
	List<Team> getTeams();
	
	Long getScoreboardRefresh();
	
	LocalTime getGameTime();
}
