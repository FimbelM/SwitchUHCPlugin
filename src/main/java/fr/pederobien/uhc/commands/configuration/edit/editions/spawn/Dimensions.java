package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Dimensions extends AbstractSpawnEdition {

	public Dimensions(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.DIMENSIONS);
	}

	@Override
	public String edit(String[] args) {
		try {
			getSpawn().setDimension(args[1], args[2], args[3]);
			return "New dimensions : " + args[1] + " " + args[2] + " " + args[3] + " defined";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the new dimension of the spawn, need <width> <height> <depth>";
		}
	}
}
