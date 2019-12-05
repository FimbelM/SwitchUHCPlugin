package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class AsCurrentHungerGame extends CommonAsCurrent<IHungerGameConfiguration> {

	public AsCurrentHungerGame(IConfigurationContext context) {
		super(context, MessageCode.AS_CURRENT_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onStyleNotDefined(String name) {
		return MessageCode.AS_CURRENT_HUNGER_GAME_NOT_EXISTING_STYLE.withArgs(name);
	}
}
