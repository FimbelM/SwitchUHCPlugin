package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.switching;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonNew;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class NewSwitchGame extends CommonNew<ISwitchGameConfiguration> {

	public NewSwitchGame() {
		super(MessageCode.NEW_SWITCH_GAME_EXPLANATION);
	}
	
	@Override
	protected void onAlreadyExisting(String name) {
		sendMessage(MessageCode.NEW_SWITCH_GAME_ALREADY_EXISTING, name);
	}

	@Override
	protected void onCreated() {
		sendMessage(MessageCode.NEW_SWITCH_GAME_CREATED, get().getName());
	}

	@Override
	protected ISwitchGameConfiguration getNew(String name) {
		return factory.createSwitchGameConfiguration(name);
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.NEW_SWITCH_GAME_MISSING_NAME);
	}
}
