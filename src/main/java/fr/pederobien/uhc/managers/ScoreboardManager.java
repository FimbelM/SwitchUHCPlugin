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
	private static int spaces;

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

	public static Objective addEmptyLine(Objective objective) {
		addEntries(objective, emptyLine());
		return objective;
	}

	public static String emptyLine() {
		String line = "";
		for (int i = 0; i < spaces; i++)
			line += " ";
		spaces++;
		return line;
	}

	private static void setPlayerScoreboardWithCurrentLocation(Player player, IScoreboard sc) {
		spaces = 0;
		if (map.get(player) == null)
			map.put(player, TeamsManager.getColor(player));
		ChatColor color = map.get(player);

		Objective obj = registerNewObjectiveOnSideBarDisplaySlot(color + sc.getTitle());

		for (String entry : sc.getEntries())
			addEntries(obj, entry);

		addEmptyLine(obj);
		addEntries(obj, showCoordinates(player));
		addEmptyLine(obj);
		player.setScoreboard(obj.getScoreboard());
	}

	private static String showCoordinates(Player player) {
		return ChatColor.GOLD + "X/Y/Z:" + ChatColor.DARK_GREEN + " " + prepareCoordinates(player);
	}

	private static String prepareCoordinates(Player player) {
		Location loc = player.getLocation();
		return loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ();
	}
}
