package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class AddTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddTeam() {
		super("addteam", "to add a team to a style");
	}

	@Override
	public String edit(String[] args) {
		try {
			ETeam team = ETeam.getByColorName(args[1]);
			team.setName(args[0]);
			List<String> players = emptyList();
			String playerNames = team.getColor() + "";
			for (int i = 2; i < args.length; i++) {
				try {
					Player player = PlayerManager.getPlayer(args[i]);
					players.add(player.getName());
					playerNames += player.getName() + " ";
				} catch (NullPointerException e) {
					return args[i] + " is not a player";
				}
			}
			if (!get().addTeam(team))
				return "A team as already the color " + team.getColorName();

			TeamsManager.createTeam(team);
			for (String player : players) {
				TeamsManager.joinTeam(team.getNameWithoutColor(), player);
				team.getPlayers().add(player);
			}

			String player;
			if (players.isEmpty())
				player = "no players added";
			else if (players.size() == 1)
				player = "player added : " + playerNames;
			else
				player = "players added : " + playerNames;
			return "Team " + team.getNameWithColor() + " created, " + player;
		} catch (IndexOutOfBoundsException e) {
			return "Cannot create a new team, arguments are missing";
		} catch (NullPointerException e) {
			return "Cannot create a new team, " + args[1] + " does not correspond to a color";
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList("<name>");
		case 2:
			List<String> teamColors = ETeam.getColorsName();
			for (ETeam team : get().getTeams())
				teamColors.remove(team.getColorName());
			return filter(teamColors, args[1]);
		}
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 2, args.length)), args[args.length - 1]);
	}
}
