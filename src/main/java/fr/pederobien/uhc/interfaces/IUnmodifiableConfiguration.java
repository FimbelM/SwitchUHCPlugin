package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;
import java.util.Map;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.game.IGame;

public interface IUnmodifiableConfiguration extends IName {
	
	IGame getGame();
	
	Map<String, ChatColor> getTeams();
	
	Long getScoreboardRefresh();
	
	LocalTime getGameTime();
}
