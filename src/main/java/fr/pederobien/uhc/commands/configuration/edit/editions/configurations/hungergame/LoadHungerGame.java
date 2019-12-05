package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class LoadHungerGame extends CommonLoad<IHungerGameConfiguration> {

	public LoadHungerGame() {
		super(MessageCode.LOAD_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onStyleLoaded(String name) {
		switch (get().getTeams().size()) {
		case 0:
			return MessageCode.LOAD_HUNGER_GAME_STYLE_NO_TEAM_CREATED_LOADED.withArgs(get().getName());
		case 1:
			return MessageCode.LOAD_HUNGER_GAME_STYLE_ONE_TEAM_CREATED_LOADED.withArgs(get().getName(),
					getTeamNamesWithColor());
		default:
			return MessageCode.LOAD_HUNGER_GAME_STYLE_TEAMS_CREATED_LOADED.withArgs(get().getName(),
					getTeamNamesWithColor());
		}
	}

	@Override
	protected MessageCode onNameIsMissing() {
		return MessageCode.LOAD_HUNGER_GAME_MISSING_NAME;
	}
}
