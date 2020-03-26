package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonDelete;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class DeleteHungerGame extends CommonDelete<IHungerGameConfiguration> {

	public DeleteHungerGame() {
		super(MessageCode.DELETE_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onDeleted(String name) {
		sendMessage(MessageCode.DELETE_HUNGER_GAME_MESSAGE, name);
	}
}
