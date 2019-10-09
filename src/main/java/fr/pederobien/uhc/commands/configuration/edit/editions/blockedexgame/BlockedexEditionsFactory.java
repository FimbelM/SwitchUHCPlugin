package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class BlockedexEditionsFactory {
	private IPersistence<IBlockedexConfiguration> persistence = ConfigurationsFactory.getInstance().getBlockedexPersistence();

	public static BlockedexEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final BlockedexEditionsFactory factory = new BlockedexEditionsFactory();
	}

	public IEdition createGameTimeEdition() {
		return new GameTime(persistence);
	}

	public IEdition createScoreboardRefreshEdition() {
		return new ScoreboardRefresh(persistence);
	}

	public IEdition createRenameEdition() {
		return new Rename(persistence);
	}

	public IEdition createLoadEdition() {
		return new Load(persistence);
	}

	public IEdition createNewConfEdition() {
		return new NewConf(persistence);
	}

	public IEdition createCurrentEdition() {
		return new Current(persistence);
	}

	public IEdition createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrent(persistence, context);
	}

	public IEdition createSaveEdition() {
		return new Save(persistence);
	}

	public IEdition createListEdition() {
		return new ListConf(persistence);
	}

	public IEdition createHelpEdition() {
		return new Help(persistence);
	}
}
