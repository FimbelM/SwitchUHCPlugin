package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonDelete;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class DeleteBlockedexGame extends CommonDelete<IBlockedexConfiguration> {

	public DeleteBlockedexGame() {
		super(MessageCode.DELETE_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_BLOCKEDEX_GAME_MESSAGE, name);
	}
}
