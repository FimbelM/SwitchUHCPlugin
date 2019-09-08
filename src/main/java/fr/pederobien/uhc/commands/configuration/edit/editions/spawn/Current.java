package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Current extends AbstractSpawnEdition {

	public Current(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.CURRENT);
	}

	@Override
	public String edit(String[] args) {
		return "Current spawn " + getSpawn().getName();
	}
}
