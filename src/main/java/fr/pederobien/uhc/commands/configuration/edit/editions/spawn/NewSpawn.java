package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class NewSpawn extends AbstractSpawnEdition {

	public NewSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.NEW);
	}

	@Override
	public String edit(String[] args) {
		try {
			String name = args[0];
			getPersistence().save();
			if (getPersistence().exist(name))
				return "The spawn " + name + " already exist";
			else {
				getPersistence().set(new Spawn(name));
				return "New spawn " + getSpawn().getName() + " created";
			}
		} catch (IndexOutOfBoundsException e) {
			return "Cannot create a new spawn, need the name";
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
