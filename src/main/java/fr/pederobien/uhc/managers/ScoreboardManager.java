package fr.pederobien.uhc.managers;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import fr.pederobien.uhc.scoreboard.IScoreboard;

public class ScoreboardManager {
	private static HashMap<Player, ChatColor> map = new HashMap<Player, ChatColor>();
	
	public static void setPlayersScoreboard(Scoreboard scoreboard) {
		for (Player player : PlayerManager.getPlayers())
			player.setScoreboard(scoreboard);
	}
	
	public static void setPlayersScoreboardWithCurrentLocation(IScoreboard sc) {
		for (Player player : PlayerManager.getPlayers())
			setPlayerScoreboardWithCurrentLocation(player, sc);
	}
	
	public static Objective registerNewObjective(String title) {
		return Bukkit.getScoreboardManager().getNewScoreboard().registerNewObjective("Objective", "dummy", title);
	}
	
	public static Objective registerNewObjective(String title, DisplaySlot displaySlot) {
		Objective obj = registerNewObjective(title);
		obj.setDisplaySlot(displaySlot);
		return obj;
	}
	
	public static Objective registerNewObjectiveOnSideBarDisplaySlot(String title) {
		return registerNewObjective(title, DisplaySlot.SIDEBAR);
	}
	
	public static void addEntries(Objective objective, String score) {
		objective.getScore(score).setScore(objective.getScoreboard().getEntries().size());
	}
	
	public static void addEntries(Objective objective, List<String> entries) {
		for (String score : entries)
			addEntries(objective, score);
	}
	
	public static void removePlayerScoreboard(Player player) {
		player.setScoreboard(registerNewObjectiveOnSideBarDisplaySlot("Removed").getScoreboard());
	}
	
	public static void removePlayersScoreboard() {
		for (Player player : PlayerManager.getPlayers())
			removePlayerScoreboard(player);
	}
	
	private static void setPlayerScoreboardWithCurrentLocation(Player player, IScoreboard sc) {
		Location loc = player.getLocation();
		if (map.get(player) == null)
			map.put(player, TeamsManager.getColor(player));
		ChatColor color = map.get(player);
		
		Objective obj = registerNewObjectiveOnSideBarDisplaySlot(sc.getTitle());
		
		for (String entry : sc.getEntries())
			addEntries(obj, color + entry);
		
		addEntries(obj, color.toString() + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ());
		addEntries(obj, color + "Coordonnées X/Y/Z");
		player.setScoreboard(obj.getScoreboard());
	}
}
