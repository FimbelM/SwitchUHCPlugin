package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;

public class EastBaseBlockedexGame extends CommonBaseBlockedexGame {

	protected EastBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "eastbase", "to set the base at the east of the spawn");
	}

	@Override
	protected void setBase(IUnmodifiableBase name) {
		get().setEastBase(name);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getEastBase().getName() + " defined as the east base";
	}
}
