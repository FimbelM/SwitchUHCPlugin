package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public class EastBaseBlockedexGame extends AbstractBaseEdition {

	protected EastBaseBlockedexGame() {
		super("east", MessageCode.BASE_EAST_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void setBase(String baseName) {
		get().setEastBase(baseName);
	}

	@Override
	protected MessageCode onBaseSetted() {
		return MessageCode.BASE_EAST_BLOCKEDEX_GAME_SETTED.withArgs(get().getEastBase());
	}
}
