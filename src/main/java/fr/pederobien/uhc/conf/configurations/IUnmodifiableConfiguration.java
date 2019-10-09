package fr.pederobien.uhc.conf.configurations;

import java.time.LocalTime;
import java.util.List;

import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.conf.IName;
import fr.pederobien.uhc.game.IGame;

public interface IUnmodifiableConfiguration extends IName {
	
	IGame getGame();
	
	List<Team> getTeams();
	
	Long getScoreboardRefresh();
	
	LocalTime getGameTime();
}