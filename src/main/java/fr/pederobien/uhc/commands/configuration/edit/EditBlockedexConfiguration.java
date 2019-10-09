package fr.pederobien.uhc.commands.configuration.edit;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame.BlockedexEditionsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;

public class EditBlockedexConfiguration extends AbstractEditConfiguration<IBlockedexConfiguration> {
	private IEdition gameTime;
	private IEdition scoreboardRefresh;
	private IEdition rename;
	private IEdition load;
	private IEdition newConf;
	private IEdition current;
	private IEdition asCurrent;
	private IEdition save;
	private IEdition list;
	private IEdition help;

	private BlockedexEditionsFactory factory;

	public EditBlockedexConfiguration(IConfigurationContext context) {
		super(context);
		factory = BlockedexEditionsFactory.getInstance();
	}

	@Override
	protected void setEditions() {
		gameTime = factory.createGameTimeEdition();
		scoreboardRefresh = factory.createScoreboardRefreshEdition();
		rename = factory.createRenameEdition();
		load = factory.createLoadEdition();
		newConf = factory.createNewConfEdition();
		current = factory.createCurrentEdition();
		asCurrent = factory.createAsCurrentEdition(context);
		save = factory.createSaveEdition();
		list = factory.createListEdition();
		help = factory.createHelpEdition();

		addToMap(gameTime, scoreboardRefresh, rename, load, newConf, current, asCurrent, save, list, help);
	}
}
