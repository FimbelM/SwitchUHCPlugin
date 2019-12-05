package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private static final BlockedexGameEditionsFactory factory = BlockedexGameEditionsFactory.getInstance();

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "bd", MessageCode.BLOCKEDEX_EDITION_CONFIGURATION_EXPLANATION);
		
		addEdition(factory.createAsCurrentEdition(context))
		.addEdition(factory.createBaseDistanceEdition())
		.addEdition(factory.createBasesEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDeleteEdition().setModifiable(false))
		.addEdition(factory.createGameTimeEdition())
		.addEdition(factory.createListEdition())
		.addEdition(factory.createLoadEdition().setModifiable(false))
		.addEdition(factory.createNewEdition().setModifiable(false))
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition())
		.addEdition(factory.createScoreboardRefreshEdition())
		.addEdition(factory.createTeamEdition());
		
		setAvailable(false);
	}
}
