package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private BlockedexGameEditionsFactory factory;

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		factory = BlockedexGameEditionsFactory.getInstance();

		addToMap(factory.createGameTimeEdition(),
				factory.createScoreboardRefreshEdition(),
				factory.createRenameEdition(),
				factory.createLoadEdition(),
				factory.createNewEdition(),
				factory.createCurrentEdition(),
				factory.createAsCurrentEdition(context),
				factory.createSaveEdition(),
				factory.createListEdition(),
				factory.createHelpEdition(this),
				factory.createNorthBaseEdition(),
				factory.createSouthBaseEdition(),
				factory.createWestBaseEdition(),
				factory.createEastBaseEdition());
	}
}
