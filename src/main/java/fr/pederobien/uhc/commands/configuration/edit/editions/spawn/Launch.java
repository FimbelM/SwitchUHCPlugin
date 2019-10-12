package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Launch extends AbstractSpawnEdition {

	public Launch(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.LAUNCH);
	}

	@Override
	public String edit(String[] args) {
		if (args.length == 0) {
			getSpawn().launch();
			return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
		} else if (args.length < 2) {
			getPersistence().save();
			try {
				getPersistence().load(args[0]);
				getSpawn().launch();
				return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
			} catch (FileNotFoundException e) {
				return "Cannot launch spawn " + args[0] + ", spawn does not exist";
			}
		} else if (args.length < 4) {
			try {
				getSpawn().setCenter(args[0], args[1], args[2]);
				getSpawn().launch();
				return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch spawn " + getSpawn().getName() + ", need center's coordinates <X> <Y> <Z>";
			} catch (NumberFormatException e) {
				return "Cannot parse width or height or depth";
			}
		} else {
			getPersistence().save();
			try {
				getPersistence().load(args[0]);
				getSpawn().setCenter(args[1], args[2], args[3]);
				getSpawn().launch();
				return "Spawn " + getSpawn().getName() + " launched at " + showBlock(getSpawn().getCenter());
			} catch (FileNotFoundException e) {
				return "Cannot launch spawn " + args[0] + ", spawn does not exist";
			} catch (IndexOutOfBoundsException e) {
				return "Cannot launch spawn " + args[0] + ", need the spawn's name and center's coordinates <X> <Y> <Z>";
			} catch (NumberFormatException e) {
				return "Cannot parse width or height or depth";
			}
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		return Arrays.asList("<nothing>", "<name>", "<X> <Y> <Z>", "<name> <X> <Y> <Z>");
	}
}
