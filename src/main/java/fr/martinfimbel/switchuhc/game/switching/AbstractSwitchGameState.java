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
		List<ITeam> copyOfTeamList = new ArrayList<ITeam>(game.getConfiguration().getTeams());

		// Getting teams that contains enough players
		ListIterator<ITeam> iterator = copyOfTeamList.listIterator();
		while (iterator.hasNext()) {
			ITeam team = iterator.next();
			if (team.getPlayersOnMode(GameMode.SURVIVAL).size() < game.getConfiguration().getNumberOfPlayerSwitchable())
				iterator.remove();
		}

		// Structure used to register random player from team
		Map<ITeam, List<Player>> randomPlayers = new HashMap<ITeam, List<Player>>();
		Map<Player, Location> randomPlayerCoordinates = new HashMap<Player, Location>();

		// Object that return random int.
		Random rand = new Random();

		// Getting a map that contains a list of random players ready to switch and a
		// map that link coordinates to a player
		for (ITeam team : copyOfTeamList) {
			Location coordinatesPlayers;
			Player player;

			List<Player> switchedPlayers = new ArrayList<Player>();
			for (int i = 0; i < game.getConfiguration().getNumberOfPlayerSwitchable(); i++)
				// getting a list of random players
				switchedPlayers.add(team.getPlayers().get(rand.nextInt(team.getPlayers().size())));
			
			randomPlayers.put(team, switchedPlayers);
			for (int i = 0; i < switchedPlayers.size(); i++) {
				coordinatesPlayers = switchedPlayers.get(i).getLocation();
				player = switchedPlayers.get(i);
				randomPlayerCoordinates.put(player, coordinatesPlayers);
			}
		}

		// Actualize teams with new teamates and teleporting players

		Player player1;
		Player player2;
		
		for (int i = 0; i < copyOfTeamList.size()-1; i++) {	
			player1 = randomPlayers.get(copyOfTeamList.get(i)).get(rand.nextInt(copyOfTeamList.get(i).getPlayers().size()));
			player2 = randomPlayers.get(copyOfTeamList.get(i+1)).get(rand.nextInt(copyOfTeamList.get(i+1).getPlayers().size()));
			
			game.getConfiguration().getTeams().get(i).removePlayer(player1);
			game.getConfiguration().getTeams().get(i+1).removePlayer(player2);
			game.getConfiguration().getTeams().get(i+1).addPlayer(player1);
			game.getConfiguration().getTeams().get(i).addPlayer(player2);
		
			PlayerManager.teleporte(player1, randomPlayerCoordinates.get(player2));
			System.out.println("Teleporting player1 to player2 coordinates");
			PlayerManager.teleporte(player2, randomPlayerCoordinates.get(player1));
			System.out.println("Teleporting player2 to player1 coordinates");
		}
		
		
		// verify if players are in same team
		
		System.out.println("RandomPlayers: " + randomPlayers);
		System.out.println("RandomPlayerCoordinates: " + randomPlayerCoordinates);
		

		sendTitle(EColor.GOLD, MessageCode.SWITCH);
	}
}
