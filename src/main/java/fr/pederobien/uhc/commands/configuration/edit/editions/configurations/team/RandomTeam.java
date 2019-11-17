package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.TeamsManager;

public class RandomTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RandomTeam() {
		super("randomteam", "to dispatch players randomly in teams");
	}

	@Override
	public String edit(String[] args) {
		TeamsManager.dispatchPlayerRandomlyInTeam(get());
		String teams = "Random teams created :\n";
		for (ETeam team : get().getTeams()) {
			teams += team.getColor() + team.getNameWithoutColor() + " [";
			for (int i = 0; i < team.getPlayers().size(); i++) {
				teams += team.getPlayers().get(i);
				if (i < team.getPlayers().size() - 1)
					teams += " ";
			}
			teams += "]\n";
		}
		return teams;
	}
}
