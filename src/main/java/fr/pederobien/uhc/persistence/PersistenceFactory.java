package fr.pederobien.uhc.persistence;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.interfaces.IPersistence;
import fr.pederobien.uhc.interfaces.ISpawn;

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
