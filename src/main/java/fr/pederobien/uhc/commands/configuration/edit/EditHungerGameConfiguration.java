package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class EditHungerGameConfiguration extends AbstractEditConfiguration<IHungerGameConfiguration> {
	private HungerGameEditionsFactory factory = HungerGameEditionsFactory.getInstance();

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super(context, "hg", "to configure a hunger game style");

		addEditions(factory.createBorderCenterEdition(),
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
