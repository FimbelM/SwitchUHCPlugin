package fr.martinfimbel.switchuhc.game.switching;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
		
		// Object that return random int.
		Random rand = new Random();

		// Getting a map that contains a list of random players ready to switch
		for (ITeam team : copyOfTeamList) {
			List<Player> switchedPlayers = new ArrayList<Player>();

			for (int i = 0; i < game.getConfiguration().getNumberOfPlayerSwitchable(); i++) {
				// getting a list of random players
				switchedPlayers.add(team.getPlayers().get(rand.nextInt(team.getPlayers().size())));
			}
			randomPlayers.put(team, switchedPlayers);				
		}
		
		// Actualize teams with new teamates and teleporte players
		Player randomPlayer1, randomPlayer2;
		
		Iterator<ITeam> iteratorTeam = randomPlayers.keySet().iterator();
		ITeam team1 = null, team2 = null;
		while (iteratorTeam.hasNext()) {
			if (team1 == null) {
				team1 = iteratorTeam.next();
				if (iteratorTeam.hasNext()) {
					team2 = iteratorTeam.next();
				}
			} else
				team2 = iterator.next();
			
			
			randomPlayer1 = team1.getPlayers().get(rand.nextInt(team1.getPlayers().size()));
			randomPlayer2 = team2.getPlayers().get(rand.nextInt(team2.getPlayers().size()));
			
			ITeam realTeam1 = game.getConfiguration().getTeamByName(team1.getName());
			ITeam realTeam2 = game.getConfiguration().getTeamByName(team2.getName());
			
			// Removing player from their real team
			synchronizedRemove(realTeam1, randomPlayer1);
			synchronizedRemove(realTeam2, randomPlayer2);
			
			// Adding players to their new team
			synchronizedAdd(realTeam1, randomPlayer2);
			synchronizedAdd(realTeam2, randomPlayer1);
			
			Location locp2 = randomPlayer2.getLocation().clone();
			
			PlayerManager.teleporte(randomPlayer2, randomPlayer1.getLocation());
			PlayerManager.teleporte(randomPlayer1, locp2);
			
			sendMessage(randomPlayer1, MessageCode.SWITCH_MESSAGE, realTeam2.toString());
			sendMessage(randomPlayer2, MessageCode.SWITCH_MESSAGE, realTeam1.toString());
			
			team1 = team2;
			team2 = null;
		}
		sendTitle(EColor.GOLD, MessageCode.SWITCH);
	}

	private boolean filterTeam(ITeam team) {
		List<Player> copyPlayers = team.getPlayersOnMode(GameMode.SURVIVAL);

		if (copyPlayers.size() <= 1) {
			return false;
		}

		if (copyPlayers.size() < game.getConfiguration().getNumberOfPlayerSwitchable()) {
			return false;
		}
		return true;
	}
	
	private static void synchronizedAdd(ITeam team, Player player) {
		team.addPlayer(player);
		TeamsManager.join(team, player);
	}
	
	private static void synchronizedRemove(ITeam team, Player player) {
		team.removePlayer(player);
		TeamsManager.leave(team, player);
	}
	
}
