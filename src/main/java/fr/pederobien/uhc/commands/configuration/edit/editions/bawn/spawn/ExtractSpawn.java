package fr.pederobien.uhc.commands.configuration.edit.editions.bawn.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.bawn.CommonExtract;
import fr.pederobien.uhc.interfaces.ISpawn;

public class ExtractSpawn extends CommonExtract<ISpawn> {

	public ExtractSpawn() {
		super("to extract spawn's blocks");
	}

	@Override
	protected String onExtracted() {
		return "Spawn " + get().getName() + " extracted";
	}
}
