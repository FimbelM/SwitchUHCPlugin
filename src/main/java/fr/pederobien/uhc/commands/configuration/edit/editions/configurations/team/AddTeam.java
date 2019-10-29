package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;

public class AddTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddTeam() {
		super("addteam", "to add a team to a style");
	}

	@Override
	public String edit(String[] args) {
		try {
			ETeam team = ETeam.getByColorName(args[1]);
			team.setName(args[0]);
			List<Player> players = new ArrayList<Player>();
			String playerNames = team.getColor() + "";
			for (int i = 2; i < args.length; i++) {
				try {
					Player player = PlayerManager.getPlayer(args[i]);
					players.add(player);
					playerNames += player.getName() + " ";
				} catch (NullPointerException e) {
					return args[i] + " is not a player";
				}
			}
			if (!get().addTeam(team))
				return "A team as already the color " + team.getColorName();

			for (Player player : players)
				team.addPlayers(player.getName());

			String player = "";
			if (players.size() == 1)
				player = ", player added : " + playerNames;
			else if (players.size() > 1)
				player = ", players added : " + playerNames;
			return "Team " + team.getNameWithColor() + " created" + player;
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
			return filter(getAvailableColors(), args[1]);
		}
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 2, args.length)), args[args.length - 1]);
	}
}
