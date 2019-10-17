package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;

public class NewBlockedexGame extends CommonNew<IBlockedexConfiguration> {

	public NewBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "to create a new blockedex game style");
	}

	@Override
	protected String onAlreadyExisting(String name) {
		return "The blockedex game style " + name + " already exist";
	}

	@Override
	protected String onCreated() {
		return "New blockedex game style " + get().getName() + " created";
	}

	@Override
	protected IBlockedexConfiguration getNew(String name) {
		return factory.createBlockedexGameConfiguration(name);
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot create a new blockedex game style, need the name";
	}

}
