package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class WestBaseBlockedexGame extends AbstractBaseEdition {

	protected WestBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "west", "to set the base at the west of the spawn");
	}

	@Override
	protected void setBase(String baseName) {
		get().setWestBase(baseName);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getWestBase() + " defined as the west base";
	}
}
