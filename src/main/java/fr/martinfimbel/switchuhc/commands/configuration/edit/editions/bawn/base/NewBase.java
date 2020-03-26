package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.bawn.base;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.CommonNew;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class NewBase extends CommonNew<IBase> {

	public NewBase() {
		super(MessageCode.NEW_BASE_EXPLANATION);
	}

	@Override
	protected void onAlreadyExisting(String name) {
		sendMessage(MessageCode.NEW_BASE_ALREADY_EXISTING, name);
	}

	@Override
	protected void onCreated() {
		sendMessage(MessageCode.NEW_BASE_CREATED, get().getName());
	}

	@Override
	protected IBase getNew(String name) {
		return factory.createBase(name);
	}

	@Override
	protected void onNameIsMissing() {
		sendMessage(MessageCode.NEW_BASE_MISSING_NAME);
	}
}
