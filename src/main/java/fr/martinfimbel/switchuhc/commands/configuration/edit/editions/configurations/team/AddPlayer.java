package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ITeam;

public class AddPlayer<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public AddPlayer() {
		super("addplayer", MessageCode.TEAM_ADDPLAYER_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String name = args[0];
		ITeam team = get().getTeamByName(name);
		if (team == null) {
			sendMessage(MessageCode.TEAM_BAD_TEAM, name);
			return;
		}

		AddPlayerEvent event = addPlayers(team, Arrays.copyOfRange(args, 1, args.length));

		if (event == null)
			return;

		switch (event.getPlayers().size()) {
		case 0:
			sendMessage(MessageCode.TEAM_ADDPLAYER_NO_PLAYER_ADDED);
			break;
		case 1:
			sendMessage(MessageCode.TEAM_ADDPLAYER_ONE_PLAYER_ADDED, event.getPlayerNames(), team.getColoredName());
			break;
		default:
			sendMessage(MessageCode.TEAM_ADDPLAYER_PLAYERS_ADDED, event.getPlayerNames(), team.getColoredName());
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
