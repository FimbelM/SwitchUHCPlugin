package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class ListTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public ListTeam() {
		super("list", "to list the existing team for a game style");
	}

	@Override
	public String edit(String[] args) {
		String teams = "";
		for (ETeam team : get().getTeams()) {
			teams += team.getColor() + team.getNameWithoutColor() + " [";
			for (int i = 0; i < team.getPlayers().size(); i++) {
				teams += team.getPlayers().get(i);
				if (i < team.getPlayers().size() - 1)
					teams += " ";
			}
			teams += "]\n";
		}
		if (get().getTeams().isEmpty())
			return "No existing team for " + get().getName() + " style";
		else if (get().getTeams().size() == 1)
			return "Existing team : \n" + teams;
		return "Existing teams : \n" + teams;
	}
}
