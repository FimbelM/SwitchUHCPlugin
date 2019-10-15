package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	public static Team getTeam(String name) {
		for (Team team : getTeams())
			if (team.getName().equals(name))
				return team;
		return null;
	}

	public static Team getTeam(ChatColor color) {
		for (Team team : getTeams())
			if (team.getColor().equals(color))
				return team;
		return null;
	}

	public static ChatColor getColor(Player player) {
		return getTeam(player) == null ? ChatColor.RESET : getTeam(player).getColor();
	}

	public static int getNumberOfPlayers(Team team) {
		return getPlayers(team).size();
	}

	public static int getNumberOfPlayerInTeam() {
		int sum = 0;
		for (Team team : getTeams())
			sum += getNumberOfPlayers(team);
		return sum;
	}

	public static List<Player> getCollegues(Player player) {
		List<Player> collegues = getPlayers(getTeam(player));
		collegues.remove(player);
		return collegues;
	}

	public static Player getRandomCollegue(Player player) {
		return getRandom(getCollegues(player));
	}

	public static Player getRandom(List<Player> players) {
		Random rand = new Random();
		return players.get(rand.nextInt(players.size()));
	}

	public static Team getTeam(Player player) {
		for (Team team : getTeams())
			if (getPlayers(team).contains(player))
				return team;
		return null;
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

	public static void teleporteTeam(Team team, Location location) {
		PlayerManager.teleporteAllPlayers(getPlayers(team), location);
	}

	public static void teleporteRandomlyTeam(Team team, int bound) {
		PlayerManager.teleporteAllPlayers(getPlayers(team), WorldManager.getRandomlyLocation(bound));
	}

	public static void teleporteRandomlyAllTeams(int bound) {
		for (Team team : getTeams())
			teleporteRandomlyTeam(team, bound);
	}

	public static void dispatchPlayerRandomlyInTeam() {
		Random rand = new Random();
		List<Player> players = PlayerManager.getPlayers();
		List<Team> teams = TeamsManager.getTeams();

		int quotient = players.size() / teams.size();
		int reste = players.size() % teams.size();

		for (int i = 0; i < teams.size(); i++) {
			int maxPlayer = 0;
			if (reste == 0)
				maxPlayer = quotient;
			else if (reste > 0) {
				maxPlayer = quotient + 1;
				reste--;
			}
			for (int j = 0; j < maxPlayer; j++) {
				Player randomPlayer = players.get(rand.nextInt(players.size()));
				TeamsManager.joinTeam(teams.get(i).getName(), randomPlayer.getName());
				players.remove(randomPlayer);
			}
		}
	}
}
