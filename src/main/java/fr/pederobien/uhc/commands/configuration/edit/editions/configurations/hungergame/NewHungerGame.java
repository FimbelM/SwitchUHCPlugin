package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

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
