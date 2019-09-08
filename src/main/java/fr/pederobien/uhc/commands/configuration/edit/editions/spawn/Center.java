package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Center extends AbstractSpawnEdition {

	public Center(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.CENTER);
	}

	@Override
	public String edit(String[] args) {
		try {
			getSpawn().setCenter(args[1], args[2], args[3]);
			return "New center : " + args[1] + " " + args[2] + " " + args[3] + " defined";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set center's coordinates, need <X> <Y> <Z>";
		}
	}

}
