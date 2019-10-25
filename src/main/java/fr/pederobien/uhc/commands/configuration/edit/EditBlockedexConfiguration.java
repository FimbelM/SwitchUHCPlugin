package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.BlockedexGameEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IMapEdition;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private static final BlockedexGameEditionsFactory factory = BlockedexGameEditionsFactory.getInstance();
	IMapEdition<IBlockedexConfiguration> load = factory.createLoadEdition();
	IMapEdition<IBlockedexConfiguration> newConf = factory.createNewEdition();

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(factory.getPersistence(), "bd", "to configure a blockedex game style");

		addUnmodifiableEdition(load).addUnmodifiableEdition(newConf);
		
		addEdition(factory.createAsCurrentEdition(context))
		.addEdition(factory.createBaseDistanceEdition())
		.addEdition(factory.createBasesEdition())
		.addEdition(factory.createCurrentEdition())
		.addEdition(factory.createGameTimeEdition())
		.addEdition(factory.createHelpEdition(this))
		.addEdition(factory.createListEdition())
		.addEdition(load)
		.addEdition(newConf)
		.addEdition(factory.createRenameEdition())
		.addEdition(factory.createSaveEdition())
		.addEdition(factory.createScoreboardRefreshEdition())
		.addEdition(factory.createTeamEdition());
	}
}
