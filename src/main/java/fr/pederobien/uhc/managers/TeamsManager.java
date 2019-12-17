package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.environment.UHCTeam;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.interfaces.IUnmodifiableConfiguration;

public class TeamsManager {
	private static Random rand = new Random();
	private static IUnmodifiableConfiguration configuration;

	public static void setCurrentConfiguration(IUnmodifiableConfiguration configuration) {
		TeamsManager.configuration = configuration;
	}

	public static ChatColor getColor(Player player) {
		if (configuration == null)
			return ChatColor.RESET;
		for (ITeam team : configuration.getTeams())
			if (team.getPlayers().contains(player))
				return team.getColor().getChatColor();
		return ChatColor.RESET;
	}

	public static ITeam createTeam(String name, EColor color) {
		return UHCTeam.createTeam(name, color);
	}

	public static ITeam getTeam(Player player) {
		for (ITeam team : configuration.getTeams())
			if (team.getPlayers().contains(player))
				return team;
		return null;
	}

	public static ITeam getTeam(EColor color) {
		for (ITeam team : configuration.getTeams())
			if (team.getColor().equals(color))
				return team;
		return null;
	}

	public static List<Player> getCollegues(Player player) {
		return configuration.getTeams().stream().filter(t -> t.getPlayers().contains(player)).findFirst().get().getPlayers().stream()
				.filter(n -> !n.equals(player)).collect(Collectors.toList());
	}

	public static Player getRandomCollegue(Player player) {
		return getRandom(getCollegues(player));
	}

	public static Player getRandom(List<Player> players) {
		Random rand = new Random();
		return players.get(rand.nextInt(players.size()));
	}

	public static void teleporteTeam(ITeam team, Location location) {
		PlayerManager.teleporteAllPlayers(team.getPlayers().stream(), location);
	}

	public static void teleporteRandomlyTeam(ITeam team, int bound) {
		teleporteTeam(team, WorldManager.getRandomlyLocation(bound));
	}

	public static void teleporteRandomlyAllTeams(IUnmodifiableConfiguration configuration, int bound) {
		configuration.getTeams().forEach(t -> teleporteRandomlyTeam(t, bound));
	}

	public static void createTeams(List<ITeam> teams) {
		for (ITeam team : teams) {
			BukkitManager.dispatchCommand("team add " + team.getName());
			BukkitManager.dispatchCommand("team modify " + team.getName() + " color " + team.getColor().getColorName());
			for (Player player : team.getPlayers())
				BukkitManager.dispatchCommand("team join " + team.getName() + " " + player.getName());
		}
	}

	public static void removeTeams(List<ITeam> teams) {
		for (ITeam team : teams)
			BukkitManager.dispatchCommand("team remove " + team.getName());
	}

	public static void dispatchPlayerRandomlyInTeam(List<ITeam> teams) {
		List<Player> players = PlayerManager.getPlayers().collect(Collectors.toList());
		for (ITeam team : teams)
			team.clear();

		List<ITeam> copy = new ArrayList<ITeam>(teams);

		int quotient = players.size() / copy.size();
		int reste = players.size() % copy.size();

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

			ITeam randomTeam = copy.get(rand.nextInt(copy.size()));
			randomTeam.addPlayer(players.get(i));
			if (randomTeam.getPlayers().size() == maxPlayer)
				copy.remove(randomTeam);
		}
	}
}
