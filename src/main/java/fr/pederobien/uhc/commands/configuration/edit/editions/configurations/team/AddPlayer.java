package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.PlayerManager;

public class AddPlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddPlayer() {
		super("addplayer", MessageCode.TEAM_ADDPLAYER_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		ETeam team = ETeam.getByName(args[0]);
		if (team == null)
			return MessageCode.TEAM_BAD_TEAM.withArgs(args[0]);

		List<Player> players = new ArrayList<Player>();
		String playerNames = "";
		for (int i = 1; i < args.length; i++) {
			try {
				Player player = PlayerManager.getPlayer(args[i]);
				players.add(player);
				playerNames += player.getName() + " ";
			} catch (NullPointerException e) {
				return MessageCode.TEAM_BAD_PLAYER.withArgs(args[i]);
			}
		}

		for (Player player : players)
			team.addPlayers(player.getName());

		switch (players.size()) {
		case 0:
			return MessageCode.TEAM_ADDPLAYER_NO_PLAYER_ADDED;
		case 1:
			return MessageCode.TEAM_ADDPLAYER_ONE_PLAYER_ADDED.withArgs(playerNames, team.getNameWithColor());
		default:
			return MessageCode.TEAM_ADDPLAYER_PLAYERS_ADDED.withArgs(playerNames, team.getNameWithColor());
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(getTeamNamesWithoutColor(), args[0]);
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 1, args.length)), args[args.length - 1]);
	}
}
