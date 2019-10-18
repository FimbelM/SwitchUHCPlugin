package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;

public class WestBaseBlockedexGame extends CommonBaseBlockedexGame {

	protected WestBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "westbase", "to set the base at the west of the spawn");
	}

	@Override
	protected void setBase(IUnmodifiableBase name) {
		get().setWestBase(name);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getWestBase().getName() + " defined as the west base";
	}
}
