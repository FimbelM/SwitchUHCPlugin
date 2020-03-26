package fr.martinfimbel.switchuhc.persistence;

import fr.martinfimbel.switchuhc.interfaces.IBase;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IPersistence;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class PersistenceFactory {
	private IPersistence<IHungerGameConfiguration> hungerGamePersistence;
	private IPersistence<IBlockedexConfiguration> blockedexPersistence;
	private IPersistence<ISpawn> spawnPersistence;
	private IPersistence<IBase> basePersistence;

	public static PersistenceFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final PersistenceFactory factory = new PersistenceFactory();
	}

	public synchronized IPersistence<IHungerGameConfiguration> getHungerGamePersistence() {
		if (hungerGamePersistence == null)
			hungerGamePersistence = new HungerGamePersistence();
		return hungerGamePersistence;
	}

	public synchronized IPersistence<IBlockedexConfiguration> getBlockedexPersistence() {
		if (blockedexPersistence == null)
			blockedexPersistence = new BlockedexPersistence();
		return blockedexPersistence;
	}

	public synchronized IPersistence<ISpawn> getSpawnPersistence() {
		if (spawnPersistence == null)
			spawnPersistence = new SpawnPersistence();
		return spawnPersistence;
	}

	public synchronized IPersistence<IBase> getBasePersistence() {
		if (basePersistence == null)
			basePersistence = new BasePersistence();
		return basePersistence;
	}
}
