package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IMessageCode;
import fr.pederobien.uhc.managers.EColor;

public class RemoveTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {
	private static final String ALL = "all";

	public RemoveTeam() {
		super("removeteam", MessageCode.TEAM_REMOVETEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		if (args[0].equals(ALL)) {
			List<EColor> teams = new ArrayList<EColor>();
			teams.addAll(get().getTeams());
			for (EColor team : teams)
				get().removeTeam(team);
			sendMessage(MessageCode.TEAM_REMOVETEAM_ALL_TEAMS_REMOVED);
			return;
		}

		List<EColor> teams = new ArrayList<EColor>();
		String teamNames = "";
		for (int i = 0; i < args.length; i++) {
			try {
				EColor team = EColor.getByName(args[i]);
				teamNames += team.getNameWithColor() + " ";
				teams.add(team);
			} catch (NullPointerException e) {
				sendMessage(MessageCode.TEAM_BAD_TEAM, args[i]);
				return;
			}
		}

		for (EColor team : teams) {
			team.removeAllPlayers();
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
			teams = Stream.concat(teams, Stream.of(ALL));
		case 2:
			teams = args[0].equals(ALL) ? emptyList().stream() : getTeams(args);
		default:
			break;
		}
		return filter(teams, args[args.length - 1]);
	}
}
