package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.exceptions.RandomTeamException;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.TeamsManager;

public class RandomTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RandomTeam() {
		super("randomteam", MessageCode.TEAM_RANDOMTEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		int maxPlayerInTeam;
		try {
			maxPlayerInTeam = args.length == 1 ? Integer.parseInt(args[0]) : -1;
			TeamsManager.dispatchPlayerRandomlyInTeam(get().getTeams(), maxPlayerInTeam);
			sendMessage(MessageCode.TEAM_RANDOMTEAM_DISPATCHED, get().showTeams());
		} catch (NumberFormatException e) {
			sendMessage(MessageCode.TEAM_RANDOMTEAM_BAD_MAX_PLAYER_FORMAT);
		} catch (RandomTeamException e) {
			sendMessage(e.getCode());
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(onTabComplete(sender, MessageCode.TEAM_RANDOMTEAM_ON_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
