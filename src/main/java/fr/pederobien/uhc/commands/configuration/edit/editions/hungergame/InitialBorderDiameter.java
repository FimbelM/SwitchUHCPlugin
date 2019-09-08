package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class InitialBorderDiameter extends AbstractHGEdition {

	public InitialBorderDiameter(HungerGamePersistence persistence) {
		super(persistence, HGEditions.INITIAL_BORDER_DIAMETER);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setInitialBorderDiameter(Integer.parseInt(args[1]));
			return "New initial border diameter " + args[1] + " defined";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the initial diameter, need diameter";
		}
	}
}
