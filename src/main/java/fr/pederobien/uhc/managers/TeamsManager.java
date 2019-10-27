package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.interfaces.IUnmodifiableConfiguration;

public class TeamsManager {
	private static IUnmodifiableConfiguration currentConfiguration;
	
	public static void setCurrentConfiguration(IUnmodifiableConfiguration currentConfiguration) {
		TeamsManager.currentConfiguration = currentConfiguration;
	}

	public static List<Team> getTeams() {
		return new ArrayList<Team>(Bukkit.getScoreboardManager().getMainScoreboard().getTeams());
	}

	public static List<String> getTeamsName() {
		List<String> teams = new ArrayList<String>();
		for (Team team : getTeams())
			teams.add(team.getName());
		return teams;
	}

	public static List<Team> getOtherTeam(Player player) {
		List<Team> others = new ArrayList<Team>();
		Team team = getTeam(player);
		for (Team t : getTeams())
			if (!t.equals(team))
				others.add(t);
		return others;

	}

	public static List<String> getOtherTeamNames(String playerName) {
		List<String> others = new ArrayList<String>();
		String teamName = getTeamName(playerName);
		for (String t : getTeamsName())
			if (!t.equals(teamName))
				others.add(t);
		return others;
	}

	public static Team getTeam(Player player) {
		for (Team team : getTeams())
			if (getPlayers(team).contains(player))
				return team;
		return null;
	}

	public static String getTeamName(Player player) {
		for (Team team : getTeams())
			if (getPlayers(team).contains(player))
				return team.getName();
		return null;
	}

	public static String getTeamName(String playerName) {
		for (Team team : getTeams())
			if (getPlayersName(team).contains(playerName))
				return team.getName();
		return null;
	}

	public static List<Player> getPlayers(Team team) {
		List<Player> players = new ArrayList<Player>();
		for (String pl : team.getEntries())
			players.add(Bukkit.getPlayer(pl));
		return players;
	}

	public static List<String> getPlayersName(Team team) {
		List<String> players = new ArrayList<String>();
		for (String pl : team.getEntries())
			players.add(Bukkit.getPlayer(pl).getName());
		return players;
	}

	public static List<String> getPlayersName(String teamName) {
		List<String> players = new ArrayList<String>();
		for (String pl : getPlayersName(getTeam(teamName)))
			players.add(Bukkit.getPlayer(pl).getName());
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

	public static List<Player> getPlayersInTeam() {
		List<Player> players = new ArrayList<Player>();
		for (Team team : getTeams())
			players.addAll(getPlayers(team));
		return players;
	}

	public static List<String> getPlayersNameInTeam() {
		List<String> players = new ArrayList<String>();
		for (Team team : getTeams())
			players.addAll(getPlayersName(team));
		return players;
	}

	public static List<Player> getPlayersNotInTeam() {
		List<Player> players = PlayerManager.getPlayers();
		for (Team team : getTeams())
			for (Player player : getPlayers(team))
				players.remove(player);
		return players;
	}

	public static List<String> getPlayersNameNotInTeam() {
		List<String> players = PlayerManager.getPlayersName();
		for (Team team : getTeams())
			for (String name : getPlayersName(team))
				players.remove(name);
		return players;
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
		return currentConfiguration.getTeams().stream()
				.filter(t -> t.getPlayers().contains(player.getName()))
				.map(t -> t.getPlayers()
						.stream().filter(n -> !n.equals(player.getName()))
						.map(n -> PlayerManager.getPlayer(n)))
				.findFirst().get().collect(Collectors.toList());
	}

	public static Player getRandomCollegue(Player player) {
		return getRandom(getCollegues(player));
	}

	public static Player getRandom(List<Player> players) {
		Random rand = new Random();
		return players.get(rand.nextInt(players.size()));
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

	public static void createTeam(String name) {
		BukkitManager.dispatchCommand("team add " + name);
	}

	public static void createTeam(ETeam team) {
		createTeam(team.getNameWithoutColor());
		setTeamOption(team.getNameWithoutColor(), "color", team.getColorName());
	}

	public static void setTeamOption(String name, String option, String value) {
		BukkitManager.dispatchCommand("team modify " + name + " " + option + " " + value);
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

	public static void dispatchPlayerRandomlyInTeam(List<ETeam> teams) {
		Random rand = new Random();
		List<Player> players = PlayerManager.getPlayers();

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
				TeamsManager.joinTeam(teams.get(i).getNameWithoutColor(), randomPlayer.getName());
				teams.get(i).getPlayers().add(randomPlayer.getName());
				players.remove(randomPlayer);
			}
		}
	}
}
