package fr.pederobien.uhc.commands.configuration.edit.editions.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.AbstractEditionsFactory;
import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.conf.ConfigurationsFactory;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.persistence.IPersistence;

public class BlockedexEditionsFactory extends AbstractEditionsFactory<IBlockedexConfiguration> {

	public static BlockedexEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	public BlockedexEditionsFactory(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final BlockedexEditionsFactory factory = new BlockedexEditionsFactory(
				ConfigurationsFactory.getInstance().getBlockedexPersistence());
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
}
