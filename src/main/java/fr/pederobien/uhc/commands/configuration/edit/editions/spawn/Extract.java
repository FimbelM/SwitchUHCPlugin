package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Extract extends AbstractSpawnEdition {

	public Extract(IPersistence<ISpawn> persistence) {
		super(persistence, "extract", "to extract world's block");
	}

	@Override
	public String edit(String[] args) {
		getSpawn().extract();
		return "Spawn " + getSpawn().getName() + " extracted";
	}
}
