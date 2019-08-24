package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.BukkitManager;

public class TeamsManager {

	public static List<Team> getTeams() {
		return new ArrayList<Team>(Bukkit.getScoreboardManager().getMainScoreboard().getTeams());
	}
	
	public static List<Player> getPlayers(Team team) {
		List<Player> players = new ArrayList<Player>();
		for (String pl : team.getEntries())
			players.add(Bukkit.getPlayer(pl));
		return players;
	}
	
	public static int getNumberOfPlayers(Team team) {
		return getPlayers(team).size();
	}
	
	public static List<Player> getTeamPlayersOnMode(Team team, GameMode mode) {
		List<Player> players = new ArrayList<Player>();
		for (String str : team.getEntries()) {
			Player player = Bukkit.getPlayer(str);
			if (player != null && player.getGameMode() == mode)
				players.add(player);
		}
		return players;
	}
	
	public static int getNumberTeamPlayersOnMode(Team team, GameMode mode) {
		return getTeamPlayersOnMode(team, mode).size();
	}
	
	public static void createTeam(String team) {
		BukkitManager.dispatchCommand("team add " + team);
	}
	
	public static void setTeamOption(String team, String option, String value) {
		BukkitManager.dispatchCommand("team modify " + team + " " + option + " " + value);
	}
	
	public static void createTeam(String team, String color) {
		createTeam(team);
		setTeamOption(team, "color", color);
	}
	
	public static void joinTeam(String team, String player) {
		BukkitManager.dispatchCommand("team join " + team + " " + player);
	}
	
	public static void joinAllToTeam(String team) {
		BukkitManager.dispatchCommand("team join " + team + " @a");
	}
	
	public static void leaveTeam(String team, String player) {
		BukkitManager.dispatchCommand("team leave " + player);
	}
	
	public static void removeTeam(String team) {
		BukkitManager.dispatchCommand("team remove " + team);
	}
	
	public static void removeAllTeam() {
		for (Team team : getTeams())
			removeTeam(team.getName());
	}
	
	public static void teleporte(String selector, int x, int y, int z) {
		BukkitManager.dispatchCommand("tp " + selector + " " + x + " " + y + " " + z);
	}
	
	public static void teleporte(String selector, Location location) {
		teleporte(selector, location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}
	
	public static void teleporteAllPlayers(int x, int y, int z) {
		teleporte("@a", x, y, z);
	}
	
	public static void teleporteAllPlayers(Location location) {
		teleporte("@a", location);
	}
	
	public static void teleporteTeam(String team, int x, int y, int z) {
		teleporte("@a[team=" + team + "]", x, y, z);
	}
	
	public static void teleporteTeam(String team, Location location) {
		teleporte("@a[team=" + team + "]", location);
	}
	
	public static void teleporteRandomly(String team) {
		teleporteTeam(team, WorldManager.getRandomlyPoint().getLocation());
	}
	
	public static void teleporteRandomlyAllTeams() {
		for (Team team : getTeams())
			teleporteRandomly(team.getName());
	}
	
	public static ChatColor getColor(Player player) {
		for (Team team : getTeams())
			if (getPlayers(team).contains(player))
				return team.getColor();
		return null;
	}
}
