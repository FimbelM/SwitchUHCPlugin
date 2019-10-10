package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.BlockedexEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private BlockedexEditionsFactory factory;

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		factory = BlockedexEditionsFactory.getInstance();

		addToMap(factory.createGameTimeEdition(),
				factory.createScoreboardRefreshEdition(),
				factory.createRenameEdition(),
				factory.createLoadEdition(),
				factory.createNewConfEdition(),
				factory.createCurrentEdition(),
				factory.createAsCurrentEdition(context),
				factory.createSaveEdition(),
				factory.createListEdition(),
				factory.createHelpEdition());
	}
}
