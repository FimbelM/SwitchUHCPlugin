package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonSave;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class SaveHungerGame extends CommonSave<IHungerGameConfiguration> {

	public SaveHungerGame() {
		super(MessageCode.SAVE_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onSave() {
		sendMessage(MessageCode.SAVE_HUNGER_GAME_SAVED, get().getName());
	}
}
