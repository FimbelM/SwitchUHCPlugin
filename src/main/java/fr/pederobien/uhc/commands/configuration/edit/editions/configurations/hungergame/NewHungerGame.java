package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.CommonNew;
import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class NewHungerGame extends CommonNew<IHungerGameConfiguration> {

	public NewHungerGame(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "to create a new hunger game style");
	}

	@Override
	protected String onAlreadyExisting(String name) {
		return "The hunger game style " + name + " already exist";
	}

	@Override
	protected String onCreated() {
		return "New hunger game style " + get().getName() + " created";
	}

	@Override
	protected IHungerGameConfiguration getNew(String name) {
		return new HungerGameConfiguration(name);
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot create a new hunger game style, need the name";
	}

}