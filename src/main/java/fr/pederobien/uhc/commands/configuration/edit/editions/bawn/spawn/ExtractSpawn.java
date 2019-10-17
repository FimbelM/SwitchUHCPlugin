package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class ExtractSpawn extends CommonExtract<ISpawn> {

	public ExtractSpawn(IPersistence<ISpawn> persistence) {
		super(persistence, "to extract spawn's blocks");
	}

	@Override
	protected String onExtracted() {
		return "Spawn " + get().getName() + " extracted";
	}

}
