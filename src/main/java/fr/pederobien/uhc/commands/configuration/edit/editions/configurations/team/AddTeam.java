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

public class AddTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddTeam() {
		super("addteam", MessageCode.TEAM_ADDTEAM_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
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
					return MessageCode.TEAM_BAD_PLAYER.withArgs(args[i]);
				}
			}
			if (!get().addTeam(team))
				return MessageCode.TEAM_ADDTEAM_ALREADY_EXISTING_COLOR.withArgs(team.getColorName());

			for (Player player : players)
				team.addPlayers(player.getName());

			switch (players.size()) {
			case 0:
				return MessageCode.TEAM_ADDTEAM_TEAM_NO_PLAYER_ADDED.withArgs(team.getNameWithColor());
			case 1:
				return MessageCode.TEAM_ADDTEAM_TEAM_ONE_PLAYER_ADDED.withArgs(team.getNameWithColor(), playerNames);
			default:
				return MessageCode.TEAM_ADDTEAM_TEAM_PLAYERS_ADDED.withArgs(team.getNameWithColor(), playerNames);
			}
		} catch (IndexOutOfBoundsException e) {
			return MessageCode.TEAM_ADDTEAM_MISSING_ARGUMENTS;
		} catch (NullPointerException e) {
			return MessageCode.TEAM_BAD_COLOR.withArgs(args[1]);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList(getMessageOnTabComplete(sender, MessageCode.NEW_NAME_TAB_COMPLETE));
		case 2:
			return filter(getAvailableColors(), args[1]);
		}
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 2, args.length)), args[args.length - 1]);
	}
}
