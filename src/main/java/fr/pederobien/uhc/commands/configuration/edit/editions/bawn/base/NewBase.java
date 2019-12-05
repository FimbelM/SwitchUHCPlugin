package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBase;

public class NewBase extends CommonNew<IBase> {

	public NewBase() {
		super(MessageCode.NEW_BASE_EXPLANATION);
	}

	@Override
	protected MessageCode onAlreadyExisting(String name) {
		return MessageCode.NEW_BASE_ALREADY_EXISTING.withArgs(name);
	}

	@Override
	protected MessageCode onCreated() {
		return MessageCode.NEW_BASE_CREATED.withArgs(get().getName());
	}

	@Override
	protected IBase getNew(String name) {
		return factory.createBase(name);
	}

	@Override
	protected MessageCode onNameIsMissing() {
		return MessageCode.NEW_BASE_MISSING_NAME;
	}
}
