package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Save extends AbstractSpawnEdition {

	public Save(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.SAVE);
	}

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return "Spawn " + getSpawn().getName() + " saved";
	}

}
