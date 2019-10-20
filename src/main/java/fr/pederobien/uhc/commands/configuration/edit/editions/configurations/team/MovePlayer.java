package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
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

public class MovePlayer<T extends IConfiguration> extends AbstractEdition<T> {

	public MovePlayer(IPersistence<T> persistence) {
		super(persistence, "moveplayer", "to move a player from its initial to its final team");
	}

	@Override
	public String edit(String[] args) {
		ETeam initiale = ETeam.getByName(args[0]);
		if (initiale == null)
			return args[0] + " does not correspond to a team";
		ETeam finale = ETeam.getByName(args[1]);
		if (finale == null)
			return args[1] + " does not correspond to a team";
		List<String> players = emptyList();
		String playerNames = "";
		for (int i = 2; i < args.length; i++)
			try {
				Player player = PlayerManager.getPlayer(args[i]);
				players.add(player.getName());
				playerNames += player.getName() + " ";
			} catch (NullPointerException e) {
				return args[i] + " is not a player";
			}

		for (String player : players) {
			TeamsManager.leaveTeam(initiale.getNameWithoutColor(), player);
			TeamsManager.joinTeam(finale.getNameWithoutColor(), player);
		}

		if (players.isEmpty())
			return "No player moved";
		else if (players.size() == 1)
			return "Player " + playerNames + "moved from " + initiale.getNameWithColor() + " to "
					+ finale.getNameWithColor();
		return "Players " + playerNames + "moved from " + initiale.getNameWithColor() + " to "
				+ finale.getNameWithColor();
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getTeamsName(), args[0]);
		case 2:
			List<String> teams = getTeamsName();
			teams.remove(args[0]);
			return filter(teams, args[args.length - 1]);
		}
		List<String> playersAlreadyMentionned = emptyList();
		for (int i = 1; i < args.length; i++)
			playersAlreadyMentionned.add(args[i]);
		return filter(getPlayersName(args[0], playersAlreadyMentionned), args[args.length - 1]);
	}

	private List<String> getTeamsName() {
		List<String> teams = new ArrayList<String>();
		for (ETeam team : get().getTeams())
			teams.add(team.getNameWithoutColor());
		return teams;
	}

	private List<String> getPlayersName(String teamName, List<String> playersAlreadyMentionned) {
		List<String> players = emptyList();
		for (String name : TeamsManager.getPlayersName(teamName)) {
			if (!playersAlreadyMentionned.contains(name))
				players.add(name);
		}
		return players;
	}
}
