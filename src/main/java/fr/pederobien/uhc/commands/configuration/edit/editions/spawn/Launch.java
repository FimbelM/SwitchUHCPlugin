package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.io.FileNotFoundException;

import fr.pederobien.uhc.commands.configuration.edit.editions.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class Launch extends AbstractSpawnEdition {

	public Launch(SpawnPersistence persistence) {
		super(persistence, SpawnEditions.LAUNCH);
	}

	@Override
	public String edit(String[] args) {
		if (args.length < 2) {
			getSpawn().launch();
			return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
		} else if (args.length < 3) {
			getPersistence().save();
			try {
				getPersistence().load(args[1]);
				getSpawn().launch();
				return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
			} catch (FileNotFoundException e) {
				return "Cannot launch the spawn, spawn does not exist";
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch the new spawn\nNeed the name";
			}
		} else if (args.length < 5) {
			try {
				getSpawn().setCenter(args[1], args[2], args[3]);
				getSpawn().launch();
				return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch the current spawn, need center's coordinates <X> <Y> <Z>";
			}
		} else {
			getPersistence().save();
			try {
				getPersistence().load(args[2]);
				getSpawn().setCenter(args[3], args[4], args[5]);
				getSpawn().launch();
				return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
			} catch (FileNotFoundException e) {
				return "Cannot launch the spawn, spawn does not exist";
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch the current spawn, need center's coordinates <X> <Y> <Z> and spawn's dimensions <width> <height> <depth>";
			}
		}
	}

}
