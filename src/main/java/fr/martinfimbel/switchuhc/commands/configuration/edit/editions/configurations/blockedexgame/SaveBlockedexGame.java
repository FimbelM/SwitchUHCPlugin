package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonSave;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class SaveBlockedexGame extends CommonSave<IBlockedexConfiguration> {

	public SaveBlockedexGame() {
		super(MessageCode.SAVE_BLOCKEDEX_GAME_EXPLANATION);
	}

	@Override
	protected void onSave() {
		sendMessage(MessageCode.SAVE_BLOCKEDEX_GAME_SAVED, get().getName());
	}
}
