package fr.martinfimbel.switchuhc.commands.configuration.edit.editions.configurations.blockedexgame.bases;

import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IMapEdition;

public class BasesFactory {

	public static BasesFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final BasesFactory factory = new BasesFactory();
	}

	public IMapEdition<IBlockedexConfiguration> createNorthBaseEdition() {
		return new NorthBaseBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createSouthBaseEdition() {
		return new SouthBaseBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createWestBaseEdition() {
		return new WestBaseBlockedexGame();
	}

	public IMapEdition<IBlockedexConfiguration> createEastBaseEdition() {
		return new EastBaseBlockedexGame();
	}
}
