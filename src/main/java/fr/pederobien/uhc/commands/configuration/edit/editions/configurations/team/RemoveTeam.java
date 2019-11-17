package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class RemoveTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {
	private static final String ALL = "all";

	public RemoveTeam() {
		super("removeteam", "to remove a team from a style");
	}

	@Override
	public String edit(String[] args) {
		if (args[0].equals(ALL)) {
			List<ETeam> teams = new ArrayList<ETeam>();
			teams.addAll(get().getTeams());
			for (ETeam team : teams)
				get().removeTeam(team);
			return "All teams have been removed";
		}

		List<ETeam> teams = new ArrayList<ETeam>();
		String teamNames = "";
		for (int i = 0; i < args.length; i++) {
			try {
				ETeam team = ETeam.getByName(args[i]);
				teams.add(team);
				teamNames += team.getNameWithColor() + " ";
			} catch (NullPointerException e) {
				return args[i] + " does not correspond to a team";
			}
		}

		for (ETeam team : teams) {
			team.removeAllPlayers();
			get().removeTeam(team);
		}

		if (teams.isEmpty())
			return "No team to remove";
		else if (teams.size() == 1)
			return "Team " + teamNames + "removed";
		return "Teams " + teamNames + "removed";
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
