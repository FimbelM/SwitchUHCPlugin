package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {
	
	public static void setPlayersScoreboard(Scoreboard scoreboard) {
		for (Player player : PlayerManager.getPlayers())
			player.setScoreboard(scoreboard);
	}
	
	public static void setPlayerScoreboardWithCurrentLocation(String title, Player player, List<String> entries) {
		Location loc = player.getLocation();
		ChatColor color = TeamsManager.getColor(player);
		List<String> clone = new ArrayList<String>();
		
		for (String score : entries) {
			score = color + score;
			clone.add(score);
		}
		
		clone.add(color.toString() + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ());
		clone.add(color + "Coordonnées X/Y/Z");
		
		Objective obj = registerNewObjectiveOnSideBarDisplaySlot(title);
		addEntries(obj, clone);
		player.setScoreboard(obj.getScoreboard());
	}
	
	public static void setPlayersScoreboardWithCurrentLocation(String title, List<String> entries) {
		for (Player player : PlayerManager.getPlayers())
			setPlayerScoreboardWithCurrentLocation(title, player, entries);
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
}
