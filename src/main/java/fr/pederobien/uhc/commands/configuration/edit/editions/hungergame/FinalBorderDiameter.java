package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class FinalBorderDiameter extends AbstractHGEdition {

	public FinalBorderDiameter(HungerGamePersistence persistence) {
		super(persistence, HGEditions.FINAL_BORDER_DIAMETER);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setFinalBorderDiameter(Integer.parseInt(args[0]));
			return "Final border diameter defined : " + getConf().getFinalBorderDiameter();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the final border diameter, need diameter";
		} catch (NumberFormatException e) {
			return "Cannot parse final diameter";
		}
	}
	
	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<finaldiameter>");
		default:
			return null;
		}
	}
}
