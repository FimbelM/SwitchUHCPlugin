package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;

public class EditHungerGameConfiguration extends AbstractEditConfiguration<IHungerGameConfiguration> {
	private HungerGameEditionsFactory factory;

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super(context);
	}

	@Override
	protected void setEditions() {
		factory = HungerGameEditionsFactory.getInstance();

		addToMap(factory.createBorderCenterEdition(),
				factory.createInitialBorderDiameterEdition(),
				factory.createFinalBorderDiameterEdition(),
				factory.createGameTimeEdition(),
				factory.createScoreboardRefreshEdition(),
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
