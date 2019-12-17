package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.team;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfiguration;

public class ListTeam<T extends IConfiguration> extends AbstractTeamEditions<T> {

	public ListTeam() {
		super("list", MessageCode.TEAM_LIST_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		String teams = showTeams();

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
