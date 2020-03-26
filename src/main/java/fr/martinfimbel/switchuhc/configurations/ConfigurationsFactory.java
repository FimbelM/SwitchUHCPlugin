package fr.martinfimbel.switchuhc.configurations;

import fr.martinfimbel.switchuhc.interfaces.IBase;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IConfigurationContext;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;
import fr.martinfimbel.switchuhc.world.blocks.Base;
import fr.martinfimbel.switchuhc.world.blocks.Spawn;

public class ConfigurationsFactory {

	public static ConfigurationsFactory getInstance() {
		return SingletonHolder.factory;
	}

	private static class SingletonHolder {
		public static final ConfigurationsFactory factory = new ConfigurationsFactory();
	}
	
	public ISwitchGameConfiguration createSwitchGameConfiguration(String name) {
		return new SwitchConfiguration(name);
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
