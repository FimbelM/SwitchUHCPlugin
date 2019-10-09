package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Extract extends AbstractSpawnEdition {

	public Extract(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.EXTRACT);
	}

	@Override
	public String edit(String[] args) {
		getSpawn().extract();
		return "Spawn " + getSpawn().getName() + " extracted";
	}
}
