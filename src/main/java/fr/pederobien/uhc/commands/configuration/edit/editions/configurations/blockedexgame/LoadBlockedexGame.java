package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonLoad;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class LoadBlockedexGame extends CommonLoad<IBlockedexConfiguration> {

	public LoadBlockedexGame(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "to load a blockedex game style");
	}

	@Override
	protected String onStyleLoaded() {
		return "Blockedex game style loaded : " + getPersistence().get().getName();
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot load blockedex game style, need the name";
	}
}
