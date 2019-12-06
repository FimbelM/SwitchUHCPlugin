package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.managers.BaseManager;

public class LoadBlockedexGame extends CommonLoad<IBlockedexConfiguration> {

	public LoadBlockedexGame() {
		super(MessageCode.LOAD_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onStyleLoaded(String name) {
		switch (get().getTeams().size()) {
		case 0:
			sendMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_NO_TEAM_CREATED_LOADED, name);
			break;
		case 1:
			sendMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_ONE_TEAM_CREATED_LOADED, name, getTeamNamesWithColor());
			break;
		default:
			sendMessage(MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_TEAMS_CREATED_LOADED, name, getTeamNamesWithColor());
			break;
		}
		BaseManager.loadBases();
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.LOAD_BLOCKEDEX_GAME_MISSING_NAME);
	}
}
