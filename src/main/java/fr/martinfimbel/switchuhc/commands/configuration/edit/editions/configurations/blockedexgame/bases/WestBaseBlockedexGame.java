package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class WestBaseBlockedexGame extends AbstractBaseEdition {

	protected WestBaseBlockedexGame() {
		super("west", MessageCode.BASE_WEST_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void setBase(String baseName) {
		get().setWestBase(baseName);
	}

	@Override
	protected void onBaseSetted() {
		sendMessage(MessageCode.BASE_WEST_BLOCKEDEX_GAME_SETTED, get().getWestBase());
	}
}
