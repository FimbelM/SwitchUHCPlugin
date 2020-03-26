package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonReset;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class ResetHungerGame extends CommonReset<IHungerGameConfiguration> {

	public ResetHungerGame() {
		super(MessageCode.RESET_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onReset(String name) {
		sendMessage(MessageCode.RESET_HUNGER_GAME_MESSAGE, name);
	}

}
