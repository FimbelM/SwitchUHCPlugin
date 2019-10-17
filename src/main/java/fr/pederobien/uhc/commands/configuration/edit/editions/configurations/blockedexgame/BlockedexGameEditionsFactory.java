package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.IEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.pederobien.uhc.configurations.IConfigurationContext;
import fr.pederobien.uhc.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.persistence.IPersistence;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BlockedexGameEditionsFactory extends AbstractConfigurationEditionsFactory<IBlockedexConfiguration> {

	public static BlockedexGameEditionsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private BlockedexGameEditionsFactory(IPersistence<IBlockedexConfiguration> persistence) {
		super(persistence);
	}

	private static class SingletonHolder {
		public static final BlockedexGameEditionsFactory factory = new BlockedexGameEditionsFactory(
				PersistenceFactory.getInstance().getBlockedexPersistence());
	}

	@Override
	public IEdition createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentBlockedexGame(persistence, context);
	}

	@Override
	public IEdition createGameTimeEdition() {
		return new GameTimeBlockedexGame(persistence);
	}

	@Override
	public IEdition createLoadEdition() {
		return new LoadBlockedexGame(persistence);
	}

	@Override
	public IEdition createListEdition() {
		return new ListeBlockedexGame(persistence);
	}

	@Override
	public IEdition createCurrentEdition() {
		return new CurrentBlockedexGame(persistence);
	}

	@Override
	public IEdition createNewEdition() {
		return new NewBlockedexGame(persistence);
	}

	@Override
	public IEdition createRenameEdition() {
		return new RenameBlockedexGame(persistence);
	}

	@Override
	public IEdition createSaveEdition() {
		return new SaveBlockedexGame(persistence);
	}
}
