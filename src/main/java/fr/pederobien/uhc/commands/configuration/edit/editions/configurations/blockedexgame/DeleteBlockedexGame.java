package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class DeleteBlockedexGame extends CommonDelete<IBlockedexConfiguration> {

	public DeleteBlockedexGame() {
		super(MessageCode.DELETE_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onDeleted(String name) {
		return MessageCode.DELETE_BLOCKEDEX_GAME_MESSAGE.withArgs(name);
	}
}
