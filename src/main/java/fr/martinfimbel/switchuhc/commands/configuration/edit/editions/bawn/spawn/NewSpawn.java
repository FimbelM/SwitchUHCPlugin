package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.spawn;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonNew;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class NewSpawn extends CommonNew<ISpawn> {

	public NewSpawn() {
		super(MessageCode.NEW_SPAWN_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String name) {
		sendMessage(MessageCode.NEW_SPAWN_ALREADY_EXISTING, name);
	}

	@Override
	protected void onCreated() {
		sendMessage(MessageCode.NEW_SPAWN_CREATED, get().getName());
	}

	@Override
	protected ISpawn getNew(String name) {
		return factory.createSpawn(name);
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.NEW_SPAWN_MISSING_NAME);
	}
}
