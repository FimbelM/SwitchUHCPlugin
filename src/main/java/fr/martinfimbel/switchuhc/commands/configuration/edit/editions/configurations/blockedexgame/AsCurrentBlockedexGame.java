package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;

public class AsCurrentBlockedexGame extends CommonAsCurrent<IBlockedexConfiguration> {

	public AsCurrentBlockedexGame(IConfigurationContext context) {
		super(context, MessageCode.AS_CURRENT_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onStyleNotDefined(String name) {
		sendMessage(MessageCode.AS_CURRENT_BLOCKEDEX_GAME_NOT_EXISTING_STYLE, name);
	}
}
