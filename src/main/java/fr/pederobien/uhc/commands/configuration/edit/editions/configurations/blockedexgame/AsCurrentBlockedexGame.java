package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.CommonAsCurrent;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IPersistence;

public class AsCurrentBlockedexGame extends CommonAsCurrent<IBlockedexConfiguration> {

	public AsCurrentBlockedexGame(IPersistence<IBlockedexConfiguration> persistence, IConfigurationContext context) {
		super(persistence, context, "to set the current blockedex game style as the current style");
	}

	@Override
	protected String onNameIsMissing() {
		return "Cannot set current blockedex game style as current style, need the name";
	}

	@Override
	protected String onStyleNotDefined() {
		return "Cannot load blockedex game style, style does not exist";
	}
}
