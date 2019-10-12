package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Current extends AbstractSpawnEdition {

	public Current(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.CURRENT);
	}

	@Override
	public String edit(String[] args) {
		return "Current spawn " + getSpawn().getName();
	}
}
