package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class Save extends AbstractSpawnEdition {

	public Save(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.SAVE);
	}

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return "Spawn " + getSpawn().getName() + " saved";
	}

}
