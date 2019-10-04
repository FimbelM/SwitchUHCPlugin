package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Rename extends AbstractSpawnEdition {

	public Rename(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.RENAME);
	}

	@Override
	public String edit(String[] args) {
		try {
			if (getPersistence().exist(args[1]))
				return "A spawn with name " + args[1] + " already exist";
			else {
				String oldName = getSpawn().getName();
				getSpawn().setName(args[1]);
				return "Spawn " + oldName + " renamed " + args[1];
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
