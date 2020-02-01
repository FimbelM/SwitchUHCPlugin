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
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.managers.TeamsManager;

public class AddTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddTeam() {
		super("addteam", MessageCode.TEAM_ADDTEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		try {
			ITeam team = TeamsManager.createTeam(args[0], EColor.getByColorName(args[1]));
			List<Player> players = new ArrayList<Player>();
			String playerNames = team.getColor().getChatColor() + "";
			for (int i = 2; i < args.length; i++) {
				try {
					Player player = PlayerManager.getPlayer(args[i]);
					playerNames += player.getName();
					players.add(player);
					if (i < args.length - 1)
						playerNames += " ";
				} catch (NullPointerException e) {
					sendMessage(MessageCode.TEAM_BAD_PLAYER, args[i]);
					return;
				}
			}

			if (!TeamsManager.isNameValide(get(), team.getName())) {
				sendMessage(MessageCode.TEAM_ALREADY_EXISTING_TEAM_NAME, team.getName());
				return;
			}

			if (!TeamsManager.isColorValide(get(), team.getColor())) {
				sendMessage(MessageCode.TEAM_ALREADY_EXISTING_TEAM_COLOR, team.getColor().getColoredColorName());
				return;
			}

			for (Player player : players)
				team.addPlayer(player);

			get().addTeam(team);

			switch (players.size()) {
			case 0:
				sendMessage(MessageCode.TEAM_ADDTEAM_TEAM_NO_PLAYER_ADDED, team.getColoredName());
				break;
			case 1:
				sendMessage(MessageCode.TEAM_ADDTEAM_TEAM_ONE_PLAYER_ADDED, team.getColoredName(), playerNames);
				break;
			default:
				sendMessage(MessageCode.TEAM_ADDTEAM_TEAM_PLAYERS_ADDED, team.getColoredName(), playerNames);
				break;
			}
		} catch (IndexOutOfBoundsException e) {
			sendMessage(MessageCode.TEAM_ADDTEAM_MISSING_ARGUMENTS);
		} catch (NullPointerException e) {
			sendMessage(MessageCode.TEAM_BAD_COLOR, args[1]);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return Arrays.asList(onTabComplete(sender, MessageCode.NEW_NAME_TAB_COMPLETE));
		case 2:
			return filter(getAvailableColors(), args[1]);
		}
		return filter(getFreePlayersName(Arrays.copyOfRange(args, 2, args.length)), args[args.length - 1]);
	}
}
