package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class AsCurrentHungerGame extends CommonAsCurrent<IHungerGameConfiguration> {

	public AsCurrentHungerGame(IConfigurationContext context) {
		super(context, MessageCode.AS_CURRENT_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onStyleNotDefined(String name) {
		sendMessage(MessageCode.AS_CURRENT_HUNGER_GAME_NOT_EXISTING_STYLE, name);
	}
}
