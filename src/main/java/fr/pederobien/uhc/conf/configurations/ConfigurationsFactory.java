package fr.pederobien.uhc.conf.configurations;

import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.interfaces.IBlockedexConfiguration;
import fr.pederobien.uhc.conf.configurations.interfaces.IHungerGameConfiguration;
import fr.pederobien.uhc.world.blocks.Base;
import fr.pederobien.uhc.world.blocks.IBase;
import fr.pederobien.uhc.world.blocks.ISpawn;
import fr.pederobien.uhc.world.blocks.Spawn;

public class ConfigurationsFactory {

	public static ConfigurationsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final ConfigurationsFactory factory = new ConfigurationsFactory();
	}

	public IHungerGameConfiguration createHungerGameConfiguration(String name) {
		return new HungerGameConfiguration(name);
	}

	public IBlockedexConfiguration createBlockedexGameConfiguration(String name) {
		return new BlockedexConfiguration(name);
	}

	public IConfigurationContext createConfigurationContext() {
		return new ConfigurationContext();
	}
	
	public ISpawn createSpawn(String name) {
		return new Spawn(name);
	}
	
	public IBase createBase(String name) {
		return new Base(name);
	}
}
