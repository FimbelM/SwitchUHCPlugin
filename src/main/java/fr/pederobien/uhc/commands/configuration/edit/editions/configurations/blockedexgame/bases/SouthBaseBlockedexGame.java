package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class SouthBaseBlockedexGame extends AbstractBaseEdition {

	protected SouthBaseBlockedexGame() {
		super("south", MessageCode.BASE_SOUTH_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void setBase(String baseName) {
		get().setSouthBase(baseName);
	}

	@Override
	protected void onBaseSetted() {
		sendMessage(MessageCode.BASE_SOUTH_BLOCKEDEX_GAME_SETTED, get().getSouthBase());
	}
}
