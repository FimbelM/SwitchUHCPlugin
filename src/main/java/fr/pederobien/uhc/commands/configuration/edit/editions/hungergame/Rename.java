package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Rename extends AbstractHGEdition {

	public Rename(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "rename", "to change the name of current hunger game style");
	}

	@Override
	public String edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				return "Cannot rename hunger game style " + get().getName() + " as " + newName
						+ ", style already exist";
			else {
				String oldName = get().getName();
				get().setName(newName);
				return "Configuration " + oldName + " renamed as " + newName;
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot rename hunger game style, need the new name";
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
