package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Current extends AbstractSpawnEdition {

	public Current(IPersistence<ISpawn> persistence) {
		super(persistence, "current", "to know the current spawn's name");
	}

	@Override
	public String edit(String[] args) {
		return "Current spawn " + get().getName();
	}
}
