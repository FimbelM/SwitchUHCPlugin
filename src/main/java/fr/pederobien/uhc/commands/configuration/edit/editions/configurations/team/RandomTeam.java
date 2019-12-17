package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.TeamsManager;

public class RandomTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RandomTeam() {
		super("randomteam", MessageCode.TEAM_RANDOMTEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		TeamsManager.dispatchPlayerRandomlyInTeam(get().getTeams());
		sendMessage(MessageCode.TEAM_RANDOMTEAM_DISPATCHED, showTeams());
	}
}
