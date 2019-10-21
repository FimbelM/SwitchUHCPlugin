package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import java.util.List;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class ListTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public ListTeam(IPersistence<T> persistence) {
		super(persistence, "list", "to list the existing team for a game style");
	}
	
	@Override
	public String edit(String[] args) {
		String teams = "";
		List<String> teamNames = getTeamNamesWithColor();
		for (String t : teamNames)
			teams += t + "\r\n";
		if (teamNames.isEmpty())
			return "No existing team for " + get().getName() + " style";
		else if (teamNames.size() == 1)
			return "Existing team : \n" + teams;
		return "Existing teams : \n" + teams;
	}
}
