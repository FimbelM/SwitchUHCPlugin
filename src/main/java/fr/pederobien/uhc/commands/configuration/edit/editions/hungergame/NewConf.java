package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class NewConf extends AbstractHGEdition {

	public NewConf(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "new", "to create a new hunger game style");
	}

	@Override
	public String edit(String[] args) {
		try {
			String name = args[0];
			getPersistence().save();
			if (getPersistence().exist(name))
				return "The hunger game style " + name + " already exist";
			else {
				getPersistence().set(new HungerGameConfiguration(name));
				return "New hunger game style " + get().getName() + " created";
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot create a new hunger game style, need the name";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<name>");
		default:
			return null;
		}
	}
}
