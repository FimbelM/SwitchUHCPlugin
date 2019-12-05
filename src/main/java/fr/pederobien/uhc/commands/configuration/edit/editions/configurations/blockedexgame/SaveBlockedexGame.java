package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonSave;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class SaveBlockedexGame extends CommonSave<IBlockedexConfiguration> {

	public SaveBlockedexGame() {
		super(MessageCode.SAVE_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected MessageCode onSave() {
		return MessageCode.SAVE_BLOCKEDEX_GAME_SAVED.withArgs(get().getName());
	}
}
