package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.team;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.exceptions.RandomTeamException;
import fr.martinfimbel.switchuhc.interfaces.IConfiguration;
import fr.martinfimbel.switchuhc.managers.TeamsManager;

public class RandomTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RandomTeam() {
		super("randomteam", MessageCode.TEAM_RANDOMTEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		int maxPlayerInTeam;
		try {
			if (args.length == 1) {
				maxPlayerInTeam = Integer.parseInt(args[0]);
				if (maxPlayerInTeam <= 0) {
					sendMessage(MessageCode.TEAM_RANDOMTEAM_MAX_PLAYER_NEGATIVE);
					return;
				}
			} else
				maxPlayerInTeam = -1;
			if (get().getTeams().size() == 0) {
				sendMessage(MessageCode.TEAM_RANDOMTEAM_NOT_ENOUGH_TEAMS);
				return;
			}

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
