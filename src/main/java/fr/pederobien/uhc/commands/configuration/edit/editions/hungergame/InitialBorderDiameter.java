package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.enumerations.HGEditions;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;

public class InitialBorderDiameter extends AbstractHGEdition {

	public InitialBorderDiameter(HungerGamePersistence persistence) {
		super(persistence, HGEditions.INITIAL_BORDER_DIAMETER);
	}

	@Override
	public String edit(String[] args) {
		try {
			getConf().setInitialBorderDiameter(Integer.parseInt(args[0]));
			return "Initial border diameter defined : " + getConf().getInitialBorderDiameter();
		} catch (IndexOutOfBoundsException e) {
			return "Cannot set the initial diameter, need diameter";
		} catch (NumberFormatException e) {
			return "Cannot parse initial diameter";
		}
	}
	
	@Override
	public List<String> getArguments(String[] subArguments) {
		switch (subArguments.length) {
		case 1:
			return Arrays.asList("<initialdiameter>");
		default:
			return null;
		}
	}
}
