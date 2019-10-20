package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEdition;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class RemovePlayer<T extends IConfiguration> extends AbstractEdition<T> {

	public RemovePlayer(IPersistence<T> persistence) {
		super(persistence, "removeplayer", "to remove players from a team");
	}

	@Override
	public String edit(String[] args) {
		ETeam team = ETeam.getByName(args[0]);
		if (team == null)
			return args[0] + " does not correspond to a team";

		List<String> players = emptyList();
		String playerNames = "";
		for (int i = 1; i < args.length; i++) {
			try {
				Player player = PlayerManager.getPlayer(args[i]);
				players.add(player.getName());
				playerNames += player.getName() + " ";
			} catch (NullPointerException e) {
				return args[i] + " is not a player";
			}
		}

		for (String player : players) {
			TeamsManager.leaveTeam(team.getNameWithoutColor(), player);
			team.removePlayer(player);
		}
		
		if (players.isEmpty())
			return "No player removed from " + team.getNameWithColor();
		if (players.size() == 1)
			return "Player " + playerNames + "removed from " + team.getNameWithColor();
		return "Players " + playerNames + "removed from " + team.getNameWithColor();
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getTeams(), args[0]);
		List<String> playersAlreadyMentionned = emptyList();
		for (int i = 1; i < args.length; i++)
			playersAlreadyMentionned.add(args[i]);
		return filter(getPlayersName(args[0], playersAlreadyMentionned), args[args.length - 1]);
	}

	private List<String> getPlayersName(String teamName, List<String> playersAlreadyMentionned) {
		List<String> players = emptyList();
		for (String name : TeamsManager.getPlayersName(teamName)) {
			if (!playersAlreadyMentionned.contains(name))
				players.add(name);
		}
		return players;
	}

	private List<String> getTeams() {
		List<String> teams = emptyList();
		for (ETeam team : get().getTeams())
			teams.add(team.getNameWithoutColor());
		return teams;
	}
}
