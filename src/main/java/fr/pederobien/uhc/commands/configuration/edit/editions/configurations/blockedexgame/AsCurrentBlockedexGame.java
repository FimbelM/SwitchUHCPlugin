package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class AsCurrentBlockedexGame extends CommonAsCurrent<IBlockedexConfiguration> {

	public AsCurrentBlockedexGame(IConfigurationContext context) {
		super(context, MessageCode.AS_CURRENT_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onStyleNotDefined(String name) {
		sendMessage(MessageCode.AS_CURRENT_BLOCKEDEX_GAME_NOT_EXISTING_STYLE, name);
	}
}
