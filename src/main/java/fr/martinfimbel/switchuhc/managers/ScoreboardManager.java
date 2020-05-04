package fr.martinfimbel.switchuhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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
import fr.pederobien.minecraftmanagers.MessageManager;
import fr.pederobien.minecraftmanagers.MessageManager.DisplayOption;
import fr.pederobien.minecraftmanagers.MessageManager.TitleMessage;
import fr.pederobien.minecraftmanagers.TeamManager;
import fr.pederobien.minecraftmanagers.TeamManager.ColleagueInfo;
import fr.pederobien.minecraftmanagers.WorldManager;

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
		
		sendColleaguesInfo(player);
		addEmptyLine(obj);
		addEntries(obj, showCoordinates(player));
		addEmptyLine(obj);
		player.setScoreboard(obj.getScoreboard());
	}

	private static String showCoordinates(Player player) {
		return ChatColor.GOLD + "X/Y/Z:" + ChatColor.DARK_GREEN + " " + prepareCoordinates(player);
	}

	private static void sendColleaguesInfo(Player player) {
		Stream<ColleagueInfo> informations;
		if (!player.getGameMode().equals(GameMode.SURVIVAL))
			informations = TeamManager.getColleaguesInfo(player);
		else
			informations = TeamManager.getColleaguesInfo(player, p -> p.getGameMode().equals(GameMode.SURVIVAL));
		List<TitleMessage> messages = new ArrayList<TitleMessage>();
		informations.forEach(source -> {
			messages.add(createTeamateNameTitle(source));
			messages.add(createTeamateOrientationTitle(source));
		});
		MessageManager.sendMessage(DisplayOption.ACTION_BAR, player, messages);
	}

	private static TitleMessage createTeamateNameTitle(ColleagueInfo source) {
		return TitleMessage.of(source.getColleague().getName(),
				TeamsManager.getTeam(source.getSource()).getColor().getColorName());
	}

	private static TitleMessage createTeamateOrientationTitle(ColleagueInfo source) {
		return TitleMessage.of(
				" | " + (source.isInDifferentWorld() ? WorldManager.getWorldNameNormalised(source.getColleague().getWorld()) + " "
						: source.getDistance() + " " + source.getArrow().getUnicode() + " "),
				true, false, EColor.WHITE.getColorName());
	}

	private static String prepareCoordinates(Player player) {
		Location loc = PlayerHelper.getPlayerLocationRelativeToBorderCenter(player);
		return loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ();
	}

}
