package fr.pederobien.uhc.conf;

import fr.pederobien.uhc.conf.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.ISpawn;
import fr.pederobien.uhc.conf.persistence.BlockedexPersistence;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;
import fr.pederobien.uhc.conf.persistence.IPersistence;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public class ConfigurationsFactory {
	private IPersistence<IHungerGameConfiguration> hungerGamePersistence;
	private IPersistence<IBlockedexConfiguration> blockedexPersistence;
	private IPersistence<ISpawn> spawnPersistence;

	public ConfigurationsFactory() {
		hungerGamePersistence = new HungerGamePersistence();
		blockedexPersistence = new BlockedexPersistence();
		spawnPersistence = new SpawnPersistence();
	}

	public static ConfigurationsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final ConfigurationsFactory factory = new ConfigurationsFactory();
	}

	public IHungerGameConfiguration createHGConfiguration(String name) {
		return new HungerGameConfiguration(name);
	}

	public IBlockedexConfiguration createBDConfiguration(String name) {
		return new BlockedexConfiguration(name);
	}

	public IConfigurationContext createContext() {
		return new ConfigurationContext();
	}

	public IPersistence<IHungerGameConfiguration> getHungerGamePersistence() {
		return hungerGamePersistence;
	}

	public IPersistence<IBlockedexConfiguration> getBlockedexConfiguration() {
		return blockedexPersistence;
	}

	public IPersistence<ISpawn> getSpawnPersistence() {
		return spawnPersistence;
	}
}