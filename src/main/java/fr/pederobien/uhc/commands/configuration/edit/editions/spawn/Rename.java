package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Rename extends AbstractSpawnEdition {

	public Rename(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.RENAME);
	}

	@Override
	public String edit(String[] args) {
		try {
			String newName = args[0];
			if (getPersistence().exist(newName))
				return "Cannot rename spawn " + getSpawn().getName() + " as " + newName + ", spawn already exist";
			else {
				String oldName = getSpawn().getName();
				getSpawn().setName(newName);
				return "Spawn " + oldName + " renamed as " + newName;
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot rename the spaw, need the name";
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
