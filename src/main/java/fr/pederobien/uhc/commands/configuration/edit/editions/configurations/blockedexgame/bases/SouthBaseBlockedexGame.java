package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class SouthBaseBlockedexGame extends AbstractBaseEdition {

	protected SouthBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "south", "to set the base at the south of the spawn");
	}

	@Override
	protected void setBase(String baseName) {
		get().setSouthBase(baseName);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getSouthBase() + " defined as the south base";
	}
}
