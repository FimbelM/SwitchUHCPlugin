package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class BorderCenterEdition extends AbstractHGEdition {

	public BorderCenterEdition(HungerGamePersistence persistence) {
		super(persistence, HGEditions.BORDER_CENTER);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setBorderCenter(args[1], args[2]);
			return "New border center : " + args[1] + " " + args[2] + " defined";
		} catch (IndexOutOfBoundsException | NullPointerException e) {
			return "Cannot set the border center, need coordinates <X> <Z>";
		}
	}

	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<X> <Z>");
		case 2:
			return Arrays.asList("<Z>");
		default:
			return null;
		}
	}
}
