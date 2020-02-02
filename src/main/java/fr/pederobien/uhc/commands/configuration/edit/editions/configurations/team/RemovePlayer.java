package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class RemovePlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RemovePlayer() {
		super("removeplayer", MessageCode.TEAM_REMOVEPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		List<Player> players = new ArrayList<Player>();
		String playerNames = "";
		for (int i = 0; i < args.length; i++) {
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
			TeamsManager.getTeam(get(), player).removePlayer(player);

		switch (players.size()) {
		case 0:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_NO_PLAYER_REMOVED);
			break;
		case 1:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_ONE_PLAYER_REMOVED, playerNames);
			break;
		default:
			sendMessage(MessageCode.TEAM_REMOVEPLAYER_PLAYERS_REMOVED, playerNames);
			break;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return filter(getOtherPlayersRegistered(args), args[args.length - 1]);
	}
}
