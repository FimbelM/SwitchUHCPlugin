package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;

public class RemovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RemovePlayer() {
		super("removeplayer", MessageCode.TEAM_REMOVEPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		ETeam team = ETeam.getByName(args[0]);
		if (team == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, args[0]);
			return;
		}

		List<String> players = emptyList();
		String playerNames = "";
		for (int i = 1; i < args.length; i++) {
			try {
				Player player = PlayerManager.getPlayer(args[i]);
				players.add(player.getName());
				playerNames += player.getName() + " ";
			} catch (NullPointerException e) {
				sendMessage(MessageCode.TEAM_BAD_PLAYER, args[i]);
				return;
			}
		}

		for (String player : players)
			team.removePlayers(player);

		switch (players.size()) {
		case 0:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_NO_PLAYER_REMOVED, team.getNameWithColor());
			break;
		case 1:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_ONE_PLAYER_REMOVED, playerNames, team.getNameWithColor());
			break;
		default:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_PLAYERS_REMOVED, playerNames, team.getNameWithColor());
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
