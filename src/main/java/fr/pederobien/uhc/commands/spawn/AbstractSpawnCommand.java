package fr.pederobien.uhc.commands.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.conf.Spawn;
import fr.pederobien.uhc.conf.persistence.SpawnPersistence;

public abstract class AbstractSpawnCommand extends AbstractCommand {
	protected static SpawnPersistence spawnPersistence = new SpawnPersistence();
	
	public AbstractSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
	
	protected Spawn getSpawn() {
		return spawnPersistence.get();
	}
}
