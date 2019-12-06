package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class NewBlockedexGame extends CommonNew<IBlockedexConfiguration> {

	public NewBlockedexGame() {
		super(MessageCode.NEW_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String name) {
		sendMessage(MessageCode.NEW_BLOCKEDEX_GAME_ALREADY_EXISTING, name);
	}

	@Override
	protected void onCreated() {
		sendMessage(MessageCode.NEW_BLOCKEDEX_GAME_CREATED, get().getName());
	}

	@Override
	protected IBlockedexConfiguration getNew(String name) {
		return factory.createBlockedexGameConfiguration(name);
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.NEW_BLOCKEDEX_GAME_MISSING_NAME);
	}
}
