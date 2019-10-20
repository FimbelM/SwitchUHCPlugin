package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.TeamsManager;

public class RemoveTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RemoveTeam(IPersistence<T> persistence) {
		super(persistence, "removeteam", "to remove a team from a style");
	}

	@Override
	public String edit(String[] args) {
		List<ETeam> teams = new ArrayList<ETeam>();
		String teamNames = "";
		for (int i = 0; i < args.length; i++) {
			try {
				ETeam team = ETeam.getByName(args[i]);
				teamNames = team.getNameWithColor() + " ";
			} catch (NullPointerException e) {
				return args[i] + " does not correspond to a team";
			}
		}

		for (ETeam team : teams) {
			TeamsManager.removeTeam(team.getNameWithoutColor());
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
		return filter(getTeams(args), args[0]);
	}
}
