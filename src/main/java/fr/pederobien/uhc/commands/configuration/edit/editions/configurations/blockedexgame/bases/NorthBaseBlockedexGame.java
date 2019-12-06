package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class NorthBaseBlockedexGame extends AbstractBaseEdition {

	protected NorthBaseBlockedexGame() {
		super("north", MessageCode.BASE_NORTH_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void setBase(String baseName) {
		get().setNorthBase(baseName);
	}

	@Override
	protected void onBaseSetted() {
		sendMessage(MessageCode.BASE_NORTH_BLOCKEDEX_GAME_SETTED, get().getNorthBase());
	}
}
