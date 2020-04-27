package fr.martinfimbel.switchuhc.managers;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import fr.martinfimbel.switchuhc.BukkitManager;
import fr.martinfimbel.switchuhc.dictionary.DictionaryManager;
import fr.martinfimbel.switchuhc.environment.UHCPlayer;
import fr.martinfimbel.switchuhc.helpers.PlayerHelper;
import fr.martinfimbel.switchuhc.interfaces.IScoreboardMessage;
import fr.martinfimbel.switchuhc.scoreboard.IScoreboard;

public class ScoreboardManager {
	private static int spaces;

	public static void setPlayersScoreboard(Scoreboard scoreboard) {
		PlayerManager.getPlayers().forEach(p -> p.setScoreboard(scoreboard));
	}

	public static void setPlayersScoreboardWithCurrentLocation(IScoreboard sc) {
		PlayerManager.getPlayers().forEach(p -> setPlayerScoreboardWithCurrentLocation(p, sc));
	}

	public static Objective registerNewObjective(String title) {
		return BukkitManager.getScoreboardManager().getNewScoreboard().registerNewObjective("Objective", "dummy",
				title);
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
		PlayerManager.getPlayers().forEach(p -> removePlayerScoreboard(p));
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
		Objective obj = registerNewObjectiveOnSideBarDisplaySlot(
				UHCPlayer.get(player).getColor().getInColor(sc.getTitle()));

		for (IScoreboardMessage message : sc.getEntries())
			if (message == null)
				addEmptyLine(obj);
			else if (message.toTranslate())
				addEntries(obj, ChatColor.GOLD + DictionaryManager.getMessage(player, message.getCode())
						+ ChatColor.DARK_GREEN + message.getMessage());
			else
				addEntries(obj, ChatColor.GOLD + message.getKey() + ChatColor.DARK_GREEN + message.getMessage());

		addEmptyLine(obj);
		for(Player p : TeamsManager.getCollegues(player))
		addEntries(obj, showDistance(player, p));
		addEmptyLine(obj);
		addEntries(obj, showCoordinates(player));
		addEmptyLine(obj);
		player.setScoreboard(obj.getScoreboard());
	}

	private static String showCoordinates(Player player) {
		return ChatColor.GOLD + "X/Y/Z:" + ChatColor.DARK_GREEN + " " + prepareCoordinates(player);
	}

	private static String showDistance(Player player, Player p2) {
		String retour = "";
		int distance = (int) PlayerManager.getDistanceBetweenCollegues(player, p2);
		double orientation = PlayerManager.getOrientationBetweenPlayers(player, p2);
		String ori = "";
		if(orientation>=-22.5 && orientation<22.5)
			ori = "Devant";
		else if(orientation>=22.5 && orientation<67.5)
			ori = "Devant gauche";
		else if(orientation>=67.5 && orientation<112.5)
			ori = "Gauche";
		else if(orientation>=112.5 && orientation<157.5)
			ori = "Derriere gauche";
		else if(orientation>=157.5 && orientation<=180)
			ori = "Derriere";
		else if (orientation>=-180 && orientation<-157.5)
			ori = "Derriere";
		else if(orientation>=-157.5 && orientation<-112.5)
			ori = "Derriere droite";
		else if(orientation>=-112.5 && orientation<-67.5)
			ori = "Droite";
		else if(orientation>=-67.5 && orientation<-22.5)
			ori = "Devant droite";
		retour = p2.getName() + " | " + distance + " " + ori;
		return ChatColor.BOLD + retour;
	}

	private static String prepareCoordinates(Player player) {
		Location loc = PlayerHelper.getPlayerLocationRelativeToBorderCenter(player);
		return loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ();
	}

}
