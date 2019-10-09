package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.BDEditions;
import fr.pederobien.uhc.conf.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class NewConf extends AbstractBDEdition {

	public NewConf(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, BDEditions.NEW);
	}

	@Override
	public String edit(String[] args) {
		try {
			String name = args[0];
			getPersistence().save();
			if (getPersistence().exist(name))
				return "The blockedex game style " + name + " already exist";
			else {
				getPersistence().set(new BlockedexConfiguration(name));
				return "New blockedex game style " + getConf().getName() + " created";
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot create a new blockedex game style, need the name";
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
