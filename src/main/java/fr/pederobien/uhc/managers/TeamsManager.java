package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.interfaces.IUnmodifiableConfiguration;

public class TeamsManager {
	private static IUnmodifiableConfiguration currentConfiguration;
	private static Random rand = new Random();

	public static void setCurrentConfiguration(IUnmodifiableConfiguration currentConfiguration) {
		TeamsManager.currentConfiguration = currentConfiguration;
	}

	public static Stream<ETeam> getTeams() {
		return currentConfiguration.getTeams().stream();
	}

	public static ETeam getTeam(Player player) {
		return getTeams().filter(t -> t.getPlayers().contains(player.getName())).findFirst().get();
	}

	public static Stream<Player> getPlayers(ETeam team) {
		return getTeams().filter(t -> t.equals(team)).findFirst().get().getPlayers().stream()
				.map(n -> PlayerManager.getPlayer(n));
	}

	public static Stream<Player> getPlayersInTeam() {
		return currentConfiguration.getPlayersRegistered().map(n -> PlayerManager.getPlayer(n));
	}
	
	public static Stream<Player> getPlayersNotInTeam() {
		List<Player> players = PlayerManager.getPlayers().collect(Collectors.toList());
		players.removeAll(getPlayersInTeam().collect(Collectors.toList()));
		return players.stream();
	}

	public static ETeam getTeam(String name) {
		return getTeams().filter(t -> t.getNameWithoutColor().equals(name)).findFirst().get();
	}

	public static ETeam getTeam(ChatColor color) {
		for (ETeam team : ETeam.values())
			if (team.getColor().equals(color))
				return team;
		return null;
	}

	public static ChatColor getColor(Player player) {
		ETeam team = ETeam.getByContent(player.getName());
		return team == null ? ChatColor.RESET : team.getColor();
	}

	public static long getNumberOfPlayers(ETeam team) {
		return getPlayers(team).count();
	}

	public static long getNumberOfPlayerInTeam() {
		return currentConfiguration.getPlayersRegistered().count();
	}

	public static List<Player> getCollegues(Player player) {
		return currentConfiguration.getTeams().stream().filter(t -> t.getPlayers().contains(player.getName()))
				.findFirst().get().getPlayers().stream().filter(n -> !n.equals(player.getName()))
				.map(n -> PlayerManager.getPlayer(n)).collect(Collectors.toList());
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
		getTeams().forEach(t -> teleporteRandomlyTeam(t, bound));
	}

	public static void dispatchPlayerRandomlyInTeam(List<ETeam> teams) {
		List<Player> players = PlayerManager.getPlayers().collect(Collectors.toList());
		for (ETeam team : teams)
			team.removeAllPlayers();
		
		List<ETeam> copy = new ArrayList<ETeam>(teams);
		
		int quotient = players.size() / teams.size();
		int reste = players.size() % teams.size();
		
		Random random = new Random();
		
		for (int i = 0; i < random.nextInt(20); i++)
			rand.nextInt(copy.size());
		
		for (int i = 0; i < players.size(); i++) {
			int maxPlayer = 0;
			if (reste == 0)
				maxPlayer = quotient;
			else if (reste > 0) {
				maxPlayer = quotient + 1;
				reste--;
			}
			
			ETeam randomTeam = copy.get(rand.nextInt(copy.size()));
			randomTeam.addPlayers(players.get(i).getName());
			if (randomTeam.getPlayers().size() == maxPlayer)
				copy.remove(randomTeam);
		}
	}
}
