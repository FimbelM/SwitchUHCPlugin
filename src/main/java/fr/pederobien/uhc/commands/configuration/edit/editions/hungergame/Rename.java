package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class Rename extends AbstractHGEdition {

	public Rename(HungerGamePersistence persistence) {
		super(persistence, HGEditions.RENAME);
	}

	@Override
	public String edit(String[] args) {
		try {
			if (getPersistence().exist(args[1]))
				return "A style with name " + args[1] + " already exist";
			else {
				String oldName = getConf().getName();
				getConf().setName(args[1]);
				return "Configuration " + oldName + " renamed " + args[1];
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
