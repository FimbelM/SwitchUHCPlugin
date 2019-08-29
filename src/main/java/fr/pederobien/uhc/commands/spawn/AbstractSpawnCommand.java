package fr.pederobien.uhc.commands.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.conf.Spawn;

public abstract class AbstractSpawnCommand extends AbstractCommand {
	protected static Spawn spawn = new Spawn();

	
	public AbstractSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
}
