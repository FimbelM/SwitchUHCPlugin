package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.hungergame.HungerGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class EditHungerGameConfiguration extends AbstractEditConfiguration<IHungerGameConfiguration> {
	private static final HungerGameEditionsFactory factory = HungerGameEditionsFactory.getInstance();

	public EditHungerGameConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "hg", "to configure a hunger game style");

		IMapEdition load = factory.createLoadEdition();
		IMapEdition newConf = factory.createNewEdition();
		
		addEditions(factory.createBorderCenterEdition(),
				factory.createInitialBorderDiameterEdition(),
				factory.createFinalBorderDiameterEdition(),
				factory.createGameTimeEdition(),
				factory.createFractionTimeEdition(),
				factory.createScoreboardRefreshEdition(),
				factory.createRenameEdition(),
				load, newConf,
				factory.createCurrentEdition(),
				factory.createAsCurrentEdition(context),
				factory.createSaveEdition(),
				factory.createListEdition(),
				factory.createHelpEdition(this),
				factory.createTeamEdition());
		
		getEditions().get(load.getLabel()).setAvailable(true);
		getEditions().get(newConf.getLabel()).setAvailable(true);
	}
	
	@Override
	public void onLoaded() {
		availableAll();
	}
	
	@Override
	public void onNewCreated() {
		availableAll();
	}
}
