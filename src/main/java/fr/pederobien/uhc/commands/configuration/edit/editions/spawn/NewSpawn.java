package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class NewSpawn extends AbstractSpawnEdition {

	public NewSpawn(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.NEW);
	}

	@Override
	public String edit(String[] args) {
		try {
			if (getPersistence().exist(args[1]))
				return "A spawn with name " + args[1] + " already exist";
			else {
				getPersistence().save();
				getPersistence().set(new Spawn(args[1]));
				return "New spawn " + getSpawn().getName() + " created";
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot create a new spawn, need the name";
		}
	}
}
