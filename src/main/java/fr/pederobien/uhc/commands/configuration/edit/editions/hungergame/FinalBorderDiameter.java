package fr.pederobien.uhc.commands.configuration.edit.editions.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class FinalBorderDiameter extends AbstractHGEdition {

	public FinalBorderDiameter(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "finalborderdiameter", "to set the initial diameter of the world's border");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setFinalBorderDiameter(Integer.parseInt(args[0]));
			return "Final border diameter defined : " + get().getFinalBorderDiameter();
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
