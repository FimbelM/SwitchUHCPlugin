package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonNew;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;
import fr.pederobien.uhc.world.blocks.Spawn;

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
		return new Spawn(name);
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot create a new spawn, need the name";
	}
}
