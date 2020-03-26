package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;

public class EastBaseBlockedexGame extends AbstractBaseEdition {

	protected EastBaseBlockedexGame() {
		super("east", MessageCode.BASE_EAST_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void setBase(String baseName) {
		get().setEastBase(baseName);
	}

	@Override
	protected void onBaseSetted() {
		sendMessage(MessageCode.BASE_EAST_BLOCKEDEX_GAME_SETTED, get().getEastBase());
	}
}
