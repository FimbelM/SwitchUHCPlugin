package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.IUnmodifiableBase;

public class NorthBaseBlockedexGame extends CommonBaseBlockedexGame {

	protected NorthBaseBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "northbase", "to set the base at the north of the spawn");
	}

	@Override
	protected void setBase(IUnmodifiableBase name) {
		get().setNorthBase(name);
	}

	@Override
	protected String onBaseSetted() {
		return "Base " + get().getNorthBase().getName() + " defined as the north base";
	}
}
