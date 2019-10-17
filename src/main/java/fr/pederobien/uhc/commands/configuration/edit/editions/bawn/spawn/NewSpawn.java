package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class NewSpawn extends CommonNew<ISpawn> {

	public NewSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, "to create a new spawn");
	}

	@Override
	protected String onAlreadyExisting(String name) {
		return "The spawn " + name + " already exist";
	}

	@Override
	protected String onCreated() {
		return "New spawn " + get().getName() + " created";
	}

	@Override
	protected ISpawn getNew(String name) {
		return factory.createSpawn(name);
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot create a new spawn, need the name";
	}
}
