package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class EditHungerGameConfiguration extends AbstractMapEdition {
	private HungerGameEditionsFactory factory = HungerGameEditionsFactory.getInstance();

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super("hg", "to configure a hunger game style");

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
				factory.createHelpEdition(this),
				factory.createTeamEdition());
	}
}
