package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;

public class AddPlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddPlayer() {
		super("addplayer", MessageCode.TEAM_ADDPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String name = args[0];
		EColor team = EColor.getByName(name);
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
			team.addPlayers(player.getName());

		switch (players.size()) {
		case 0:
			sendMessage(MessageCode.TEAM_ADDPLAYER_NO_PLAYER_ADDED);
			break;
		case 1:
			sendMessage(MessageCode.TEAM_ADDPLAYER_ONE_PLAYER_ADDED, playerNames, team.getNameWithColor());
			break;
		default:
			sendMessage(MessageCode.TEAM_ADDPLAYER_PLAYERS_ADDED, playerNames, team.getNameWithColor());
			break;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getTeamNamesWithoutColor(), args[0]);
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 1, args.length)), args[args.length - 1]);
	}
}
