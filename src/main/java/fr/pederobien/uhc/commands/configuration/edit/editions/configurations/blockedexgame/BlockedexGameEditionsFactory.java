package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.commands.configuration.edit.editions.configurations.AbstractConfigurationEditionsFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.interfaces.IPersistence;
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
	public IMapEdition createAsCurrentEdition(IConfigurationContext context) {
		return new AsCurrentBlockedexGame(persistence, context);
	}

	@Override
	public IMapEdition createGameTimeEdition() {
		return new GameTimeBlockedexGame(persistence);
	}

	@Override
	public IMapEdition createLoadEdition() {
		return new LoadBlockedexGame(persistence);
	}

	@Override
	public IMapEdition createListEdition() {
		return new ListeBlockedexGame(persistence);
	}

	@Override
	public IMapEdition createCurrentEdition() {
		return new CurrentBlockedexGame(persistence);
	}

	@Override
	public IMapEdition createNewEdition() {
		return new NewBlockedexGame(persistence);
	}

	@Override
	public IMapEdition createRenameEdition() {
		return new RenameBlockedexGame(persistence);
	}

	@Override
	public IMapEdition createSaveEdition() {
		return new SaveBlockedexGame(persistence);
	}

	public IMapEdition createNorthBaseEdition() {
		return new NorthBaseBlockedexGame(persistence);
	}

	public IMapEdition createSouthBaseEdition() {
		return new SouthBaseBlockedexGame(persistence);
	}

	public IMapEdition createWestBaseEdition() {
		return new WestBaseBlockedexGame(persistence);
	}

	public IMapEdition createEastBaseEdition() {
		return new EastBaseBlockedexGame(persistence);
	}

	public IMapEdition createBaseDistanceEdition() {
		return new BaseDistanceBlockedexGame(persistence);
	}
}
