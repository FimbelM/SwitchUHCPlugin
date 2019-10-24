package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases.BasesFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class CommonBase extends AbstractConfEdition<IBlockedexConfiguration> {
	private static final BasesFactory factory = BasesFactory.getInstance();

	protected CommonBase() {
		super("base", "to set bases of a blockedex game style");

		addEdition(factory.createEastBaseEdition())
		.addEdition(factory.createNorthBaseEdition())
		.addEdition(factory.createSouthBaseEdition())
		.addEdition(factory.createWestBaseEdition());
	}
}
