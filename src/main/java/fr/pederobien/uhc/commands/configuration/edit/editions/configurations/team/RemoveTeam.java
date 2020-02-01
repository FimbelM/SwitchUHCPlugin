package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.interfaces.ITeam;
import fr.pederobien.uhc.managers.TeamsManager;

public class RemoveTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RemoveTeam() {
		super("removeteam", MessageCode.TEAM_REMOVETEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		List<ITeam> teams = new ArrayList<ITeam>();

		if (args[0].equals(TeamsManager.ALL)) {
			teams.addAll(get().getTeams());
			for (ITeam team : teams)
				get().removeTeam(team);
			sendMessage(MessageCode.TEAM_REMOVETEAM_ALL_TEAMS_REMOVED);
			return;
		}

		String teamNames = "";
		for (int i = 0; i < args.length; i++) {
			try {
				ITeam team = get().getTeamByName(args[i]);
				teamNames += team.getColoredName();
				teams.add(team);
				if (i < args.length)
					teamNames += " ";
			} catch (NullPointerException e) {
				sendMessage(MessageCode.TEAM_BAD_TEAM, args[i]);
				return;
			}
		}

		for (ITeam team : teams) {
			team.clear();
			get().removeTeam(team);
		}

		IMessageCode code;
		String localArgs = null;
		switch (teams.size()) {
		case 0:
			code = MessageCode.TEAM_REMOVETEAM_NO_TEAM_REMOVED;
			break;
		case 1:
			code = MessageCode.TEAM_REMOVETEAM_ONE_TEAM_REMOVED;
			localArgs = teamNames;
			break;
		default:
			code = MessageCode.TEAM_REMOVETEAM_TEAMS_REMOVED;
			localArgs = teamNames;
			break;
		}
		sendMessage(code, localArgs);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		Stream<String> teams = getTeams(args);
		switch (args.length) {
		case 1:
			teams = Stream.concat(teams, Stream.of(TeamsManager.ALL));
			break;
		case 2:
			teams = args[0].equals(TeamsManager.ALL) ? ((List<String>) emptyList()).stream() : getTeams(args);
			break;
		default:
			break;
		}
		return filter(teams, args[args.length - 1]);
	}
}
