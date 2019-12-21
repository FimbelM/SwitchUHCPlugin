package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonReset;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class ResetBlockedexGame extends CommonReset<IBlockedexConfiguration> {

	public ResetBlockedexGame() {
		super(MessageCode.RESET_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_BLOCKEDEX_GAME_MESSAGE, name);
	}
}
