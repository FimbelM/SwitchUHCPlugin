package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.AbstractConfEdition;
import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame.bases.BasesFactory;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class CommonBase extends AbstractConfEdition<IBlockedexConfiguration> {
	private static final BasesFactory factory = BasesFactory.getInstance();

	protected CommonBase() {
		super("base", MessageCode.BASE_BLOCKEDEX_GAME_EXPLANATION);

		addEdition(factory.createEastBaseEdition()).addEdition(factory.createNorthBaseEdition()).addEdition(factory.createSouthBaseEdition())
				.addEdition(factory.createWestBaseEdition());
	}
}
