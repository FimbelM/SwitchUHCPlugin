package fr.pederobien.uhc.commands.configuration.edit.editions.bawn;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IPersistence;

public class CommonCenter<T extends IBawn> extends AbstractBawnEdition<T> {

	public CommonCenter(IPersistence<T> persistence) {
		super(persistence, "center", "to set the center");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setCenter(args[0], args[1], args[2]);
			return "Center defined in : " + get().getCenter().getX() + " " + get().getCenter().getY()
					+ " " + get().getCenter().getZ();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set center's coordinates, need <X> <Y> <Z>";
		} catch (NumberFormatException e) {
			return "Cannot parse <X> or <Y> or <Z> argument";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<X> <Y> <Z>");
		case 2:
			return Arrays.asList("<Y> <Z>");
		case 3:
			return Arrays.asList("<Z>");
		default:
			return null;
		}
	}
}
