package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.interfaces.IUnmodifiableConfiguration;

public class TeamsManager {
	private static Random rand = new Random();

	public static ChatColor getColor(Player player) {
		ETeam team = ETeam.getByContent(player.getName());
		return team == null ? ChatColor.RESET : team.getColor();
	}

	public static List<Player> getCollegues(IUnmodifiableConfiguration configuration, Player player) {
		return configuration.getTeams().stream().filter(t -> t.getPlayers().contains(player.getName())).findFirst()
				.get().getPlayers().stream().filter(n -> !n.equals(player.getName()))
				.map(n -> PlayerManager.getPlayer(n)).collect(Collectors.toList());
	}

	public static Player getRandomCollegue(IUnmodifiableConfiguration configuration, Player player) {
		return getRandom(getCollegues(configuration, player));
	}

	public static Player getRandom(List<Player> players) {
		Random rand = new Random();
		return players.get(rand.nextInt(players.size()));
	}

	public static void teleporteTeam(ETeam team, Location location) {
		PlayerManager.teleporteAllPlayers(team.getPlayers().stream().map(n -> PlayerManager.getPlayer(n)), location);
	}

	public static void teleporteRandomlyTeam(ETeam team, int bound) {
		teleporteTeam(team, WorldManager.getRandomlyLocation(bound));
	}

	public static void teleporteRandomlyAllTeams(IUnmodifiableConfiguration configuration, int bound) {
		configuration.getTeams().forEach(t -> teleporteRandomlyTeam(t, bound));
	}
	
	public static void createTeams(List<ETeam> teams) {
		for (ETeam team : teams) {
			BukkitManager.dispatchCommand("team add " + team.getNameWithoutColor());
			BukkitManager.dispatchCommand("team modify " + team.getNameWithoutColor() + " color " + team.getColorName());
			for (String player : team.getPlayers())
				BukkitManager.dispatchCommand("team join " + team.getNameWithoutColor() + " " + player);
		}
	}
	
	public static void removeTeams(List<ETeam> teams) {
		for (ETeam team : teams)
			BukkitManager.dispatchCommand("team remove " + team.getNameWithoutColor());
	}

	public static void dispatchPlayerRandomlyInTeam(IUnmodifiableConfiguration configuration) {
		List<Player> players = PlayerManager.getPlayers().collect(Collectors.toList());
		for (ETeam team : configuration.getTeams())
			team.removeAllPlayers();

		List<ETeam> copy = new ArrayList<ETeam>(configuration.getTeams());

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

			ETeam randomTeam = copy.get(rand.nextInt(copy.size()));
			randomTeam.addPlayers(players.get(i).getName());
			if (randomTeam.getPlayers().size() == maxPlayer)
				copy.remove(randomTeam);
		}
	}
}
