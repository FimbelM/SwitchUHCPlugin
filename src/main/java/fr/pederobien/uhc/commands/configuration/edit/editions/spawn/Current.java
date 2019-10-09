package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Current extends AbstractSpawnEdition {

	public Current(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.CURRENT);
	}

	@Override
	public String edit(String[] args) {
		return "Current spawn " + getSpawn().getName();
	}
}
