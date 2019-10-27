package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

	public static List<ETeam> getTeams() {
		return currentConfiguration.getTeams();
	}

	public static ETeam getTeam(Player player) {
		return getTeams().stream().filter(t -> t.getPlayers().contains(player.getName())).findFirst().get();
	}

	public static List<Player> getPlayers(ETeam team) {
		return getTeams().stream().
		filter(t -> t.equals(team))
		.findFirst().get().getPlayers().stream().map(n -> PlayerManager.getPlayer(n)).collect(Collectors.toList());
	}

	public static List<String> getPlayersName(Team team) {
		List<String> players = new ArrayList<String>();
		for (String pl : team.getEntries())
			players.add(Bukkit.getPlayer(pl).getName());
		return players;
	}

	public static ETeam getTeam(String name) {
		return getTeams().stream().filter(t -> t.getNameWithoutColor().equals(name)).findFirst().get();
	}

	public static ETeam getTeam(ChatColor color) {
		return getTeams().stream().filter(t -> t.getColor().equals(color)).findFirst().get();
	}

	public static List<Player> getPlayersInTeam() {
		return currentConfiguration.getPlayersRegistered().stream().map(n -> PlayerManager.getPlayer(n)).collect(Collectors.toList());
	}

	public static ChatColor getColor(Player player) {
		return getTeam(player) == null ? ChatColor.RESET : getTeam(player).getColor();
	}

	public static int getNumberOfPlayers(ETeam team) {
		return getPlayers(team).size();
	}

	public static int getNumberOfPlayerInTeam() {
		return currentConfiguration.getPlayersRegistered().size();
	}

	public static List<Player> getCollegues(Player player) {
		return currentConfiguration
				.getTeams().stream().filter(t -> t.getPlayers().contains(player.getName())).map(t -> t.getPlayers()
						.stream().filter(n -> !n.equals(player.getName())).map(n -> PlayerManager.getPlayer(n)))
				.findFirst().get().collect(Collectors.toList());
	}

	public static Player getRandomCollegue(Player player) {
		return getRandom(getCollegues(player));
	}

	public static Player getRandom(List<Player> players) {
		Random rand = new Random();
		return players.get(rand.nextInt(players.size()));
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
		currentConfiguration.getTeams().clear();
	}

	public static void teleporteTeam(ETeam team, Location location) {
		PlayerManager.teleporteAllPlayers(getPlayers(team), location);
	}

	public static void teleporteRandomlyTeam(ETeam team, int bound) {
		PlayerManager.teleporteAllPlayers(getPlayers(team), WorldManager.getRandomlyLocation(bound));
	}

	public static void teleporteRandomlyAllTeams(int bound) {
		getTeams().stream().forEach(t -> teleporteRandomlyTeam(t, bound));
	}

	public static void dispatchPlayerRandomlyInTeam(List<ETeam> teams) {
		Random rand = new Random();
		List<Player> players = PlayerManager.getPlayers().collect(Collectors.toList());

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
