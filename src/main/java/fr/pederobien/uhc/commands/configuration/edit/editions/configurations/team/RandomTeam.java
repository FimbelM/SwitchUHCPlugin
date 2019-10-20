package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.managers.ETeam;
import fr.pederobien.uhc.managers.TeamsManager;

public class RandomTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RandomTeam(IPersistence<T> persistence) {
		super(persistence, "randomteam", "to dispatch players randomly in teams");
	}
	
	@Override
	public String edit(String[] args) {
		TeamsManager.dispatchPlayerRandomlyInTeam(get().getTeams());
		String players = "";
		for (ETeam team : get().getTeams()) {
			for (String player : team.getPlayers())
				players += player + " ";
			players += "have been added to " + team.getNameWithColor() + "\r\n";
		}
		return players;
	}
}
