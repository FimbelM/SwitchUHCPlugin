package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame;

import java.util.Arrays;
import java.util.List;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class InitialBorderDiameterHungerGame extends AbstractConfEdition<IHungerGameConfiguration> {

	public InitialBorderDiameterHungerGame(IPersistence<IHungerGameConfiguration> persistence) {
		super(persistence, "initialborderdiameter", "to set the initial diameter of the world's border");
	}

	@Override
	public String edit(String[] args) {
		try {
			get().setInitialBorderDiameter(Integer.parseInt(args[0]));
			return "Initial border diameter defined : " + get().getInitialBorderDiameter();
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
