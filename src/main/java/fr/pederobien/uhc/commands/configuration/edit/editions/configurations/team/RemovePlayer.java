package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.managers.PlayerManager;

public class RemovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RemovePlayer() {
		super("removeplayer", MessageCode.TEAM_REMOVEPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String name = args[0];
		ITeam team = get().getTeamByName(name);

		if (team == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, name);
			return;
		}

		List<Player> players = new ArrayList<Player>();
		String playerNames = "";
		for (int i = 1; i < args.length; i++) {
			try {
				Player player = PlayerManager.getPlayer(args[i]);
				playerNames += player.getName() + " ";
				players.add(player);
			} catch (NullPointerException e) {
				sendMessage(MessageCode.TEAM_BAD_PLAYER, args[i]);
				return;
			}
		}

		for (Player player : players)
			team.removePlayer(player);

		switch (players.size()) {
		case 0:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_NO_PLAYER_REMOVED, team.getColoredName());
			break;
		case 1:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_ONE_PLAYER_REMOVED, playerNames, team.getColoredName());
			break;
		default:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_PLAYERS_REMOVED, playerNames, team.getColoredName());
			break;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getTeamNamesWithoutColor(), args[0]);
		return filter(getPlayersName(args[0], Arrays.copyOfRange(args, 1, args.length)), args[args.length - 1]);
	}
}
