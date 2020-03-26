package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonDelete;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class DeleteBlockedexGame extends CommonDelete<IBlockedexConfiguration> {

	public DeleteBlockedexGame() {
		super(MessageCode.DELETE_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_BLOCKEDEX_GAME_MESSAGE, name);
	}
}
