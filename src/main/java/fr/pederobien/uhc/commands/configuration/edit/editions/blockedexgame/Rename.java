package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Rename extends AbstractBDEdition {

	public Rename(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "rename", "to change the name of current blockedex game style");
	}

	@Override
	public String edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				return "Cannot rename blockedex game style " + get().getName() + " as " + newName
						+ ", style already exist";
			else {
				String oldName = get().getName();
				get().setName(newName);
				return "Configuration " + oldName + " renamed as " + newName;
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot rename blockedex game style, need the new name";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<newname>");
		default:
			return null;
		}
	}
}
