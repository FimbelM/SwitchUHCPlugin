package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases.BasesFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;

public class CommonBase extends AbstractConfEdition<IBlockedexConfiguration> {
	private BasesFactory factory;

	protected CommonBase(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence, "base", "to set bases of a blockedex game style");

		factory = BasesFactory.getInstance();

		addEditions(factory.createEastBaseEdition(),
				factory.createNorthBaseEdition(),
				factory.createSouthBaseEdition(),
				factory.createWestBaseEdition());
	}
}
