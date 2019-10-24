package fr.pederobien.uhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.persistence.PersistenceFactory;

public class BasesFactory {
	private IPersistence<IBlockedexConfiguration> persistence;

	protected BasesFactory() {
		persistence = PersistenceFactory.getInstance().getBlockedexPersistence();
	}

	public static BasesFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final BasesFactory factory = new BasesFactory();
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
}
