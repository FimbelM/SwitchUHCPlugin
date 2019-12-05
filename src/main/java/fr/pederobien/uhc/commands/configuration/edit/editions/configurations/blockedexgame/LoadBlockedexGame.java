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
	protected MessageCode onStyleLoaded(String name) {
		MessageCode message;
		switch (get().getTeams().size()) {
		case 0 :
			message = MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_NO_TEAM_CREATED_LOADED.withArgs(name);
		case 1 :
			message = MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_ONE_TEAM_CREATED_LOADED.withArgs(name, getTeamNamesWithColor());
		default :
			message = MessageCode.LOAD_BLOCKEDEX_GAME_STYLE_TEAMS_CREATED_LOADED.withArgs(name, getTeamNamesWithColor());
		}
		BaseManager.loadBases();
		return message;
	}

	@Override
	protected MessageCode onNameIsMissing() {
		return MessageCode.LOAD_BLOCKEDEX_GAME_MISSING_NAME;
	}
}
