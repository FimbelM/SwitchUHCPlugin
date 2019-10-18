package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class WestBaseBlockedexGame extends CommonBaseBlockedexGame {

	protected WestBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "westbase", "to set the base at the west of the spawn");
	}

	@Override
	protected void setBase(String name) {
		get().setWestBase(name);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getWestBase() + " defined as the west base";
	}
}
