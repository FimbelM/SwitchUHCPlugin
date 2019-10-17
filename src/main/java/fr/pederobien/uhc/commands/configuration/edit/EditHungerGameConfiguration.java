package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.configurations.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

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
				factory.createFractionTimeEdition(),
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
