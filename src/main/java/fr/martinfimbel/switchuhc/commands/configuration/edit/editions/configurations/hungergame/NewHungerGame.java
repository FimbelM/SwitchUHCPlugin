package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonNew;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class NewHungerGame extends CommonNew<IHungerGameConfiguration> {

	public NewHungerGame() {
		super(MessageCode.NEW_HUNGER_GAME_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String name) {
		sendMessage(MessageCode.NEW_HUNGER_GAME_ALREADY_EXISTING, name);
	}

	@Override
	protected void onCreated() {
		sendMessage(MessageCode.NEW_HUNGER_GAME_CREATED, get().getName());
	}

	@Override
	protected IHungerGameConfiguration getNew(String name) {
		return factory.createHungerGameConfiguration(name);
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.NEW_HUNGER_GAME_MISSING_NAME);
	}
}
