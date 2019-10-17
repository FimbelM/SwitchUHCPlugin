package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.world.blocks.IBawn;

public class CommonDimensions<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonDimensions(IPersistence<T> persistence) {
		super(persistence, "dimensions", "to set the dimensions (width height depth)");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setDimensions(args[0], args[1], args[2]);
			return "Dimensions defined as : " + get().getWidth() + " " + get().getHeight() + " " + get().getDepth();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot change dimensions, need <width> <height> <depth>";
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
