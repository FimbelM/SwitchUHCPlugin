package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private static final BlockedexGameEditionsFactory factory = BlockedexGameEditionsFactory.getInstance();

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "bd", "to configure a blockedex game style");
		
		addEdition(factory.createAsCurrentEdition(context))
		.addEdition(factory.createBaseDistanceEdition())
		.addEdition(factory.createBasesEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createDeleteEdition().setUnmodifiable(true))
		.addEdition(factory.createGameTimeEdition())
		.addEdition(factory.createHelpEdition(this).setUnmodifiable(true))
		.addEdition(factory.createListEdition())
		.addEdition(factory.createLoadEdition().setUnmodifiable(true))
		.addEdition(factory.createNewEdition().setUnmodifiable(true))
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition())
		.addEdition(factory.createScoreboardRefreshEdition())
		.addEdition(factory.createTeamEdition());
		
		setAvailable(false);
	}
}
