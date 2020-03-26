package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class CurrentHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public CurrentHungerGame() {
		super("current", MessageCode.CURRENT_HUNGER_GAME_EXPLANATION);
	}

	@Override
	public void edit(String[] args) {
		sendMessage(MessageCode.CURRENT_HUNGER_GAME_MESSAGE, get().toString());
	}
}
