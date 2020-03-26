package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

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
