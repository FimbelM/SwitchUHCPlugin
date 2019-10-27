package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class MovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public MovePlayer() {
		super("moveplayer", "to move a player from its initial to its final team");
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
			return filter(getTeamNamesWithoutColor(), args[0]);
		case 2:
			return filter(getTeamNamesWithoutColor().filter(n -> !n.equals(args[0])), args[args.length - 1]);
		}
		return filter(getPlayersName(args[0], Stream.of(Arrays.copyOfRange(args, 1, args.length))), args[args.length - 1]);
	}
}
