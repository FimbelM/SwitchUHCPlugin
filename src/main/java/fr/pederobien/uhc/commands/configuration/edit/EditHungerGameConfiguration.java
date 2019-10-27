package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IMapEdition;

public class EditHungerGameConfiguration extends AbstractEditConfiguration<IHungerGameConfiguration> {
	private static final HungerGameEditionsFactory factory = HungerGameEditionsFactory.getInstance();
	IMapEdition<IHungerGameConfiguration> load = factory.createLoadEdition();
	IMapEdition<IHungerGameConfiguration> newConf = factory.createNewEdition();

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "hg", "to configure a hunger game style");
				
		addEdition(factory.createAsCurrentEdition(context))
		.addEdition(factory.createBorderCenterEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createFinalBorderDiameterEdition())
		.addEdition(factory.createFractionTimeEdition())
		.addEdition(factory.createHelpEdition(this).setUnmodifiable(true))
		.addEdition(factory.createInitialBorderDiameterEdition())
		.addEdition(factory.createListEdition())
		.addEdition(factory.createLoadEdition().setUnmodifiable(true))
		.addEdition(factory.createNewEdition().setUnmodifiable(true))
		.addEdition(factory.createPvpTimeEdition())
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition())
		.addEdition(factory.createScoreboardRefreshEdition())
		.addEdition(factory.createTeamEdition())
		.addEdition(factory.createWarningTimeEdition());
	}
}
