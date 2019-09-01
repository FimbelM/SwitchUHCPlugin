package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.conf.persistence.HungerGamePersistence;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public abstract class AbstractConfigurationCommand extends AbstractCommand {
	protected static HungerGamePersistence hgPersistence = new HungerGamePersistence();
	protected static SpawnPersistence spPersistence = new SpawnPersistence();
	
	public AbstractConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command);		
	}	
}
