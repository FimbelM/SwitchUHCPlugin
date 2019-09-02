package fr.pederobien.uhc.managers;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import fr.pederobien.uhc.scoreboard.IScoreboard;

public class ScoreboardManager {
	
	public static void setPlayersScoreboard(Scoreboard scoreboard) {
		for (Player player : PlayerManager.getPlayers())
			player.setScoreboard(scoreboard);
	}
	
	public static void setPlayerScoreboardWithCurrentLocation(IScoreboard scoreboard) {
		Location loc = scoreboard.getPlayer().getLocation();
		
		scoreboard.getEntries().add(scoreboard.getChatColor() + (loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ()));
		scoreboard.getEntries().add(scoreboard.getChatColor() + "Coordonnées X/Y/Z");
		
		Objective obj = registerNewObjectiveOnSideBarDisplaySlot(scoreboard.getTitle());
		addEntries(obj, scoreboard.getEntries());
		scoreboard.getPlayer().setScoreboard(obj.getScoreboard());
	}
	
	public static void setPlayersScoreboardWithCurrentLocation(List<IScoreboard> scoreboards) {
		for (IScoreboard scoreboard : scoreboards)
			setPlayerScoreboardWithCurrentLocation(scoreboard);
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
