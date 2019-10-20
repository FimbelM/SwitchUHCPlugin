package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class AddPlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddPlayer(IPersistence<T> persistence) {
		super(persistence, "addplayer", "to add players into a team");
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
			TeamsManager.joinTeam(team.getNameWithoutColor(), player);
			team.addPlayer(player);
		}
		if (players.isEmpty())
			return "No players added";
		else if (players.size() == 1)
			return "Player " + playerNames + "added to " + team.getNameWithColor();
		return "Players " + playerNames + " added to " + team.getNameWithColor();
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getTeamNamesWithoutColor(), args[0]);
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 1, args.length)), args[args.length - 1]);
	}
}
