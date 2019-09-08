package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import fr.pederobien.uhc.commands.configuration.edit.editions.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class FinalBorderDiameter extends AbstractHGEdition {

	public FinalBorderDiameter(HungerGamePersistence persistence) {
		super(persistence, HGEditions.FINAL_BORDER_DIAMETER);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setFinalBorderDiameter(Integer.parseInt(args[1]));
			return "New final border diameter " + args[1] + " defined";
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the final border diameter, need diameter";
		}
	}
}
