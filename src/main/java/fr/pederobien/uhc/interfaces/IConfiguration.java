package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;
import java.util.HashMap;

import org.bukkit.ChatColor;

public interface IConfiguration extends IUnmodifiableConfiguration {
	
	void setName(String name);

	void setTeams(HashMap<String, ChatColor> teams);

	void setScoreboardRefresh(Long refresh);

	void setGameTime(LocalTime gameTime);
}
