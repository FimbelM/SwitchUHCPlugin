package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Remove extends AbstractSpawnEdition {

	public Remove(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.REMOVE);
	}

	@Override
	public String edit(String[] args) {
		getSpawn().remove();
		return "Spawn " + getSpawn().getName() + " removed from the world";
	}
}
