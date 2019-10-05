package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class Rename extends AbstractHGEdition {

	public Rename(HungerGamePersistence persistence) {
		super(persistence, HGEditions.RENAME);
	}

	@Override
	public String edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				return "Cannot rename hunger game style " + getConf().getName() + " as " + newName + ", style already exist";
			else {
				String oldName = getConf().getName();
				getConf().setName(newName);
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
