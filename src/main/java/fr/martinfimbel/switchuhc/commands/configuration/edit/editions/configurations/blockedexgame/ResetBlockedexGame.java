package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonReset;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class ResetBlockedexGame extends CommonReset<IBlockedexConfiguration> {

	public ResetBlockedexGame() {
		super(MessageCode.RESET_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_BLOCKEDEX_GAME_MESSAGE, name);
	}
}
