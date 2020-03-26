package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class LoadSwitchGame extends CommonLoad<ISwitchGameConfiguration> {
	public LoadSwitchGame() {
		super(MessageCode.LOAD_SWITCH_GAME_EXPLANATION);
	}

	@Override
	protected void onStyleLoaded(String name) {
		switch (get().getTeams().size()) {
		case 0:
			sendMessage(MessageCode.LOAD_SWITCH_GAME_STYLE_NO_TEAM_CREATED_LOADED, get().getName());
			break;
		case 1:
			sendMessage(MessageCode.LOAD_SWITCH_GAME_STYLE_ONE_TEAM_CREATED_LOADED, get().getName(),
					getTeamNamesWithColor());
			break;
		default:
			sendMessage(MessageCode.LOAD_SWITCH_GAME_STYLE_TEAMS_CREATED_LOADED, get().getName(),
					getTeamNamesWithColor());
			break;
		}
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.LOAD_SWITCH_GAME_MISSING_NAME);
	}
}
