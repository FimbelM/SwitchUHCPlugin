package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.base;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IPersistence;

public class NewBase extends CommonNew<IBase> {

	public NewBase(IPersistence<IBase> persistence) {
		super(persistence, "to create a new base");
	}

	@Override
	protected String onAlreadyExisting(String name) {
		return "The base " + name + " already exist";
	}

	@Override
	protected String onCreated() {
		return "New base " + get().getName() + " created";
	}

	@Override
	protected IBase getNew(String name) {
		return factory.createBase(name);
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot create a new spawn, need the name";
	}
}
