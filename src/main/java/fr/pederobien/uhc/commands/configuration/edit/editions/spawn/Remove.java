package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Remove extends AbstractSpawnEdition {

	public Remove(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.REMOVE);
	}

	@Override
	public String edit(String[] args) {
		getSpawn().remove();
		return "Spawn " + getSpawn().getName() + " removed from the world";
	}
}
