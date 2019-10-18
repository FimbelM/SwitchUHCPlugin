package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class SouthBaseBlockedexGame extends CommonBaseBlockedexGame {

	protected SouthBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "southbase", "to set the base at the south of the spawn");
	}

	@Override
	protected void setBase(String name) {
		get().setSouthBase(name);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getSouthBase() + " defined as the south base";
	}
}
