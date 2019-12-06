package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;
import fr.pederobien.uhc.managers.ETeam;

public class ListTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public ListTeam() {
		super("list", MessageCode.TEAM_LIST_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
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

		switch (get().getTeams().size()) {
		case 0:
			sendMessage(MessageCode.TEAM_LIST_NO_EXISTING_TEAM, get().getName());
			break;
		case 1:
			sendMessage(MessageCode.TEAM_LIST_ONE_EXISTING_TEAM, get().getName(), teams);
			break;
		default:
			sendMessage(MessageCode.TEAM_LIST_EXISTING_TEAMS, get().getName(), teams);
			break;
		}
	}
}
