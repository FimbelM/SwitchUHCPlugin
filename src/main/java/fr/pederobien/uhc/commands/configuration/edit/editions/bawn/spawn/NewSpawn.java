package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.ISpawn;

public class NewSpawn extends CommonNew<ISpawn> {

	public NewSpawn() {
		super(MessageCode.NEW_SPAWN_EXPLANATION);
	}

	@Override
	protected MessageCode onAlreadyExisting(String name) {
		return MessageCode.NEW_SPAWN_ALREADY_EXISTING.withArgs(name);
	}

	@Override
	protected MessageCode onCreated() {
		return MessageCode.NEW_SPAWN_CREATED.withArgs(get().getName());
	}

	@Override
	protected ISpawn getNew(String name) {
		return factory.createSpawn(name);
	}

	@Override
	protected MessageCode onNameIsMissing() {
		return MessageCode.NEW_SPAWN_MISSING_NAME;
	}
}
