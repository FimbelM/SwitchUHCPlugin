package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class CurrentBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public CurrentBlockedexGame() {
		super("current", MessageCode.CURRENT_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_BLOCKEDEX_GAME_MESSAGE, get().toString());
	}
}
