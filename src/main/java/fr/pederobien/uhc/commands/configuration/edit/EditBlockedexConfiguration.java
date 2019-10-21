package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private static final BlockedexGameEditionsFactory factory = BlockedexGameEditionsFactory.getInstance();

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "bd", "to configure a blockedex game style");

		IMapEdition load = factory.createLoadEdition();
		IMapEdition newConf = factory.createNewEdition();
		
		addEditions(factory.createGameTimeEdition(),
				factory.createScoreboardRefreshEdition(),
				factory.createRenameEdition(),
				load, newConf,
				factory.createCurrentEdition(),
				factory.createAsCurrentEdition(context),
				factory.createSaveEdition(),
				factory.createListEdition(),
				factory.createHelpEdition(this),
				factory.createNorthBaseEdition(),
				factory.createSouthBaseEdition(),
				factory.createWestBaseEdition(),
				factory.createEastBaseEdition(),
				factory.createBaseDistanceEdition(),
				factory.createTeamEdition());
		
		getEditions().get(load.getLabel()).setAvailable(true);
		getEditions().get(newConf.getLabel()).setAvailable(true);
	}
	
	@Override
	public void onLoaded() {
		for (String label : getEditions().keySet())
			getEditions().get(label).setAvailable(true);
	}
}
