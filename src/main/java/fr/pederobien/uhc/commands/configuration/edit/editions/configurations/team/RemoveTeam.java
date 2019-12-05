package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class RemoveTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {
	private static final String ALL = "all";

	public RemoveTeam() {
		super("removeteam", MessageCode.TEAM_REMOVETEAM_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		if (args[0].equals(ALL)) {
			List<ETeam> teams = new ArrayList<ETeam>();
			teams.addAll(get().getTeams());
			for (ETeam team : teams)
				get().removeTeam(team);
			return MessageCode.TEAM_REMOVETEAM_ALL_TEAMS_REMOVED;
		}

		List<ETeam> teams = new ArrayList<ETeam>();
		String teamNames = "";
		for (int i = 0; i < args.length; i++) {
			try {
				ETeam team = ETeam.getByName(args[i]);
				teams.add(team);
				teamNames += team.getNameWithColor() + " ";
			} catch (NullPointerException e) {
				return MessageCode.TEAM_BAD_TEAM.withArgs(args[i]);
			}
		}

		for (ETeam team : teams) {
			team.removeAllPlayers();
			get().removeTeam(team);
		}

		switch (teams.size()) {
		case 0:
			return MessageCode.TEAM_REMOVETEAM_NO_TEAM_REMOVED;
		case 1:
			return MessageCode.TEAM_REMOVETEAM_ONE_TEAM_REMOVED.withArgs(teamNames);
		default:
			return MessageCode.TEAM_REMOVETEAM_TEAMS_REMOVED.withArgs(teamNames);
		}
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
