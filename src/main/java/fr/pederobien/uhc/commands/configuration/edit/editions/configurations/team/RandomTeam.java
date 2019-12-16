package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.EColor;
import fr.pederobien.uhc.managers.TeamsManager;

public class RandomTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public RandomTeam() {
		super("randomteam", MessageCode.TEAM_RANDOMTEAM_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		TeamsManager.dispatchPlayerRandomlyInTeam(get());
		String teams = "";
		for (EColor team : get().getTeams()) {
			teams += team.getColor() + team.getNameWithoutColor() + " [";
			for (int i = 0; i < team.getPlayers().size(); i++) {
				teams += team.getPlayers().get(i);
				if (i < team.getPlayers().size() - 1)
					teams += " ";
			}
			teams += "]\n";
		}
		sendMessage(MessageCode.TEAM_RANDOMTEAM_DISPATCHED, teams);
	}
}
