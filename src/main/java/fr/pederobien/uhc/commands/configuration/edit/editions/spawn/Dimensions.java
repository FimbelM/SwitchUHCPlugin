package fr.pederobien.uhc.commands.configuration.edit.editions.spawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.SpawnEditions;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.ISpawn;

public class Dimensions extends AbstractSpawnEdition {

	public Dimensions(IPersistence<ISpawn> persistence) {
		super(persistence, SpawnEditions.DIMENSIONS);
	}

	@Override
	public String edit(String[] args) {
		try {
			getSpawn().setDimensions(args[0], args[1], args[2]);
			return "Spawn dimensions defined as : " + getSpawn().getWidth() + " " + getSpawn().getHeight() + " "
					+ getSpawn().getDepth();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot change spawn's dimensions, need <width> <height> <depth>";
		} catch (NumberFormatException e) {
			return "Cannot parse width or height or depth";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<width> <height> <depth>");
		case 2:
			return Arrays.asList("<height> <depth>");
		case 3:
			return Arrays.asList("<depth>");
		default:
			return null;
		}
	}
}
