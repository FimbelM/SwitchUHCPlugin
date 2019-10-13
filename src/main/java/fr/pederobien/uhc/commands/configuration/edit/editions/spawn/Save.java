package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Save extends AbstractSpawnEdition {

	public Save(IPersistence<ISpawn> persistence) {
		super(persistence, "save", "to save a spawn");
	}

	@Override
	public String edit(String[] args) {
		getPersistence().save();
		return "Spawn " + get().getName() + " saved";
	}

}
