package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class CurrentBlockedexGame extends AbstractConfEdition<IBlockedexConfiguration> {

	public CurrentBlockedexGame() {
		super("current", MessageCode.AS_CURRENT_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	public MessageCode edit(String[] args) {
		return MessageCode.CURRENT_BLOCKEDEX_GAME_MESSAGE.withArgs(get().getName());
	}
}
