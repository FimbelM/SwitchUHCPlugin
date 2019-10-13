package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;

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
				factory.createHelpEdition(this));
	}
}
