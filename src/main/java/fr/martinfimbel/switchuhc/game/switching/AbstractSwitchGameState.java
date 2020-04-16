package fr.martinfimbel.switchuhc.game.switching;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.game.AbstractGameState;
import fr.martinfimbel.switchuhc.interfaces.ITeam;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.PlayerManager;
import fr.martinfimbel.switchuhc.managers.TeamsManager;
import fr.martinfimbel.switchuhc.managers.WorldManager;
import fr.martinfimbel.switchuhc.task.TimeLine;

public class AbstractSwitchGameState extends AbstractGameState<IUnmodifiableSwitchConfiguration>
		implements ISwitchGameState {
	protected static TimeLine timeLine;
	protected static boolean alreadyWarned;
	protected ISwitchGame game;

	public AbstractSwitchGameState(ISwitchGame game) {
		super(game.getConfiguration());
		this.game = game;
	}

	protected void shouldStopGame() {
		if (PlayerManager.getNumberOfPlayersOnMode(GameMode.SURVIVAL) == 1)
			stop();
	}

	protected void authorizedPvp() {
		sendTitle(EColor.DARK_RED, MessageCode.PVP_ENABLED);
		WorldManager.setPVP(true);
	}

	protected void warnPlayers() {
		if (!alreadyWarned)
			warn(getConfiguration().getWarningTime());
		alreadyWarned = true;
	}

	protected void warn(LocalTime time) {
		WorldManager.getPlayersInWorld(WorldManager.NETHER_WORLD, WorldManager.END_WORLD)
				.forEach(p -> sendMessage(p, MessageCode.PLAYER_MUST_GO_BACK_TO_THE_OVERWORLD, "" + time.getHour(),
						"" + time.getMinute(), "" + time.getSecond()));
	}

	protected LocalTime getAbsoluteWarningTime() {
		return getConfiguration().getGameTime().minusSeconds(getConfiguration().getWarningTime().toSecondOfDay());
	}

	protected void Switch() {
		// Copy of current teams in game
		List<ITeam> copyOfTeamList = new ArrayList<ITeam>();
		for (ITeam team : game.getConfiguration().getTeams())
			copyOfTeamList.add((ITeam) team.clone());

		// Getting teams that contains enough players
		ListIterator<ITeam> iterator = copyOfTeamList.listIterator();

		while (iterator.hasNext()) {
			ITeam team = iterator.next();

			if (!filterTeam(team))
				iterator.remove();
		}

		if (copyOfTeamList.size() <= 1)
			return;

		// Display selected teams and players they contain
		System.out.println("Teams selected with switchable players : ");
		for (int team = 0; team < copyOfTeamList.size(); team++) {
			String teamName = copyOfTeamList.get(team).getName();
			String playerNames = "";
			for (int player = 0; player < copyOfTeamList.get(team).getPlayers().size(); player++) {
				playerNames += copyOfTeamList.get(team).getPlayers().get(player).getName();
			}
			System.out.println(teamName + " : " + playerNames);
		}

		// Structure used to register random player from team
		Map<ITeam, List<Player>> randomPlayers = new HashMap<ITeam, List<Player>>();
		Map<ITeam, List<Player>> randomPlayersActualized = new HashMap<ITeam, List<Player>>();
		List<Player> players = new ArrayList<Player>();

		// Object that return random int.
		Random rand = new Random();

		// Getting a map that contains a list of random players ready to switch
		for (ITeam team : copyOfTeamList) {
			List<Player> switchedPlayers = new ArrayList<Player>();
			for (int i = 0; i < game.getConfiguration().getNumberOfPlayerSwitchable(); i++) {
				// getting a list of random players

				switchedPlayers.add(team.getPlayers().get(rand.nextInt(team.getPlayers().size())));
			}
			players.addAll(switchedPlayers);
			randomPlayers.put(team, switchedPlayers);
			randomPlayersActualized.put(team, switchedPlayers);
		}

		// Sauvegarde des équipes initiales des joueurs
		Map<Player, ITeam> initialTeamPerPlayer = new HashMap<Player, ITeam>();
		for (Player p : players) {
			initialTeamPerPlayer.put(p, TeamsManager.getTeam(p));
		}

		// Début de la boucle qui va déterminer les équipes après switch
		List<ITeam> remainingTeamList = new ArrayList<ITeam>();
		Map<Player, Player> playerSwitchedWith = new HashMap<Player, Player>();
		do {

			if (remainingTeamList.size() == 0)
				remainingTeamList = new ArrayList<ITeam>(copyOfTeamList);
			Player randomP1;
			ITeam currentTeamP1;

			do {
				randomP1 = players.get(rand.nextInt(players.size()));
				currentTeamP1 = initialTeamPerPlayer.get(randomP1);
			} while (!remainingTeamList.contains(currentTeamP1));

			players.remove(randomP1);
			Player randomP2;
			ITeam currentTeamP2;
			List<Player> actualTeamateOfP2 = new ArrayList<Player>();
			Boolean samePreviousTeamOfTeamates = false;

			// sélection du 2ème joueur switché
			do {
				randomP2 = players.get(rand.nextInt(players.size()));
				currentTeamP2 = initialTeamPerPlayer.get(randomP2);
				actualTeamateOfP2 = randomPlayersActualized.get(currentTeamP2);
				actualTeamateOfP2.remove(randomP2);

				for (Player p : actualTeamateOfP2) {
					if (initialTeamPerPlayer.get(p).equals(currentTeamP1)) {
						samePreviousTeamOfTeamates = true;
						break;
					}
				}
			} while (currentTeamP1 == currentTeamP2 && samePreviousTeamOfTeamates);

			playerSwitchedWith.put(randomP1, randomP2);
			players.remove(randomP2);

			randomPlayersActualized.get(currentTeamP1).remove(randomP1);
			randomPlayersActualized.get(currentTeamP2).remove(randomP2);
			randomPlayersActualized.get(currentTeamP1).add(randomP2);
			randomPlayersActualized.get(currentTeamP2).add(randomP1);
			remainingTeamList.remove(currentTeamP1);

		} while (players.size() > 1);

		// Actualize teams with new teamates and teleporte players
		for (Map.Entry<Player, Player> entry : playerSwitchedWith.entrySet()) {
			Player player1 = entry.getKey();
			Player player2 = entry.getValue();

			System.out.println(player1.getName() + " switch avec " + player2.getName());
			ITeam realTeam1 = initialTeamPerPlayer.get(player1);
			ITeam realTeam2 = initialTeamPerPlayer.get(player2);

			// Removing player from their real team
			synchronizedRemove(realTeam1, player1);
			synchronizedRemove(realTeam2, player2);

			// Adding players to their new team
			synchronizedAdd(realTeam1, player2);
			synchronizedAdd(realTeam2, player1);

			// Teleporting player switched to their new location
			Location locp2 = player2.getLocation().clone();

			PlayerManager.teleporte(player2, player1.getLocation());
			PlayerManager.teleporte(player1, locp2);

			sendMessage(player1, MessageCode.SWITCH_MESSAGE, realTeam2.toString());
			sendMessage(player2, MessageCode.SWITCH_MESSAGE, realTeam1.toString());

		}

		// Reinitialisation des équipes initiales pour chaque joueur en prévision du
		// prochain switch
		for (ITeam t : copyOfTeamList) {
			for (Player p : randomPlayersActualized.get(t)) {
				initialTeamPerPlayer.put(p, t);
			}
		}
		sendTitle(EColor.GOLD, MessageCode.SWITCH);
	}

	private boolean filterTeam(ITeam team) {
		List<Player> copyPlayers = team.getPlayersOnMode(GameMode.SURVIVAL);
		String letter = game.getConfiguration().getOnePlayerSwitch();

		if (letter.equalsIgnoreCase("N")) {
			if (copyPlayers.size() <= 1) {
				return false;
			}
		} else {
			if (copyPlayers.size() < game.getConfiguration().getNumberOfPlayerSwitchable()) {
				return false;
			}
		}
		return true;
	}

	private static void synchronizedAdd(ITeam team, Player player) {
		team.addPlayer(player);
		TeamsManager.join(team, player);
	}

	private static void synchronizedRemove(ITeam team, Player player) {
		team.removePlayer(player);
		TeamsManager.leave(player);
	}

}
