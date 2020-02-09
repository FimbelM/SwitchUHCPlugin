package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.environment.UHCTeam;
import fr.pederobien.uhc.exceptions.RandomTeamException;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.interfaces.IUnmodifiableConfiguration;

public class TeamsManager {
	public static final String ALL = "all";
	private static Random rand = new Random();
	private static IUnmodifiableConfiguration configuration;

	public static void setCurrentConfiguration(IUnmodifiableConfiguration configuration) {
		TeamsManager.configuration = configuration;
	}

	public static ITeam createTeam(String name, EColor color) {
		return UHCTeam.createTeam(name, color);
	}

	public static ITeam getTeam(IUnmodifiableConfiguration conf, Player player) {
		for (ITeam team : conf.getTeams())
			if (team.getPlayers().contains(player))
				return team;
		return null;
	}

	public static ITeam getTeam(Player player) {
		return getTeam(configuration, player);
	}

	public static ITeam getTeam(EColor color) {
		for (ITeam team : configuration.getTeams())
			if (team.getColor().equals(color))
				return team;
		return null;
	}

	public static List<Player> getCollegues(Player player) {
		return configuration.getTeams().stream().filter(t -> t.getPlayers().contains(player)).findFirst().get().getPlayers().stream().filter(n -> !n.equals(player))
				.collect(Collectors.toList());
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
			team.setCreatedOnServer(true);
		}
	}

	public static void removeTeams(List<ITeam> teams) {
		for (ITeam team : teams) {
			if (team.isCreatedOnServer())
				BukkitManager.dispatchCommand("team remove " + team.getName());
			team.setCreatedOnServer(false);
		}
	}

	public static void dispatchPlayerRandomlyInTeam(List<ITeam> teams, int maxPlayerInTeam) {
		List<Player> players = PlayerManager.getPlayers().collect(Collectors.toList());
		List<ITeam> copy = new ArrayList<ITeam>(teams);

		for (ITeam team : teams)
			team.clear();

		if (maxPlayerInTeam == -1)
			dispatchPlayers(copy, players);
		else {
			checkEnoughPlayers(maxPlayerInTeam, players.size());
			int nbTeam = checkEnoughTeam(maxPlayerInTeam, players.size(), copy.size());

			for (int i = 0; i < teams.size() - nbTeam; i++)
				copy.remove(rand.nextInt(copy.size()));

			dispatchPlayers(copy, players, maxPlayerInTeam);
		}
	}

	public static boolean isNameForbidden(String name) {
		return name.equals(ALL);
	}

	public static boolean isNameValide(IConfiguration conf, String name) {
		return isValide(conf, t -> t.getName().equals(name));
	}

	public static boolean isColorValide(IConfiguration conf, EColor color) {
		return isValide(conf, t -> t.getColor().equals(color));
	}

	private static boolean isValide(IConfiguration conf, Predicate<ITeam> filter) {
		for (ITeam team : conf.getTeams())
			if (filter.test(team))
				return false;
		return true;
	}

	private static void checkEnoughPlayers(int maxPlayerInTeam, int nbPlayer) {
		if (nbPlayer <= maxPlayerInTeam)
			throw new RandomTeamException(MessageCode.TEAM_RANDOMTEAM_NOT_ENOUGH_PLAYERS);
	}

	private static int checkEnoughTeam(int maxPlayerInTeam, int nbPlayer, int nbTeam) {
		int nbTeams = nbPlayer / maxPlayerInTeam + (nbPlayer % maxPlayerInTeam > 0 ? 1 : 0);
		if (nbTeam < nbTeams)
			throw new RandomTeamException(MessageCode.TEAM_RANDOMTEAM_NOT_ENOUGH_TEAMS);
		return nbTeams;
	}

	private static void dispatchPlayers(List<ITeam> copy, List<Player> players, int maxPlayerInTeam) {
		for (int i = 0; i < players.size(); i++) {
			ITeam randomTeam = copy.get(rand.nextInt(copy.size()));
			randomTeam.addPlayer(players.get(i));
			if (randomTeam.getPlayers().size() == maxPlayerInTeam)
				copy.remove(randomTeam);
		}
	}

	private static void dispatchPlayers(List<ITeam> copy, List<Player> players) {
		int quotient = players.size() / copy.size();
		int reste = players.size() % copy.size();

		for (Player player : players) {
			int maxPlayer = quotient + (reste > 0 ? 1 : 0);

			ITeam randomTeam;
			do {
				randomTeam = copy.get(rand.nextInt(copy.size()));
			} while (removeTeam(copy, randomTeam, maxPlayer));

			randomTeam.addPlayer(player);

			if (removeTeam(copy, randomTeam, maxPlayer))
				reste--;
		}
	}

	private static boolean removeTeam(List<ITeam> teams, ITeam randomTeam, int maxPlayer) {
		boolean removed = randomTeam.getPlayers().size() == maxPlayer;
		if (removed)
			teams.remove(randomTeam);
		return removed;
	}
}
