package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class NorthBaseBlockedexGame extends CommonBaseBlockedexGame {

	protected NorthBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "northbase", "to set the base at the north of the spawn");
	}

	@Override
	protected void setBase(String baseName) {
		get().setNorthBase(baseName);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getNorthBase() + " defined as the north base";
	}
}
