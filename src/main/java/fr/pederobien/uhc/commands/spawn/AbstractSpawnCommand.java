package fr.pederobien.uhc.commands.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.AbstractConfCommand;
import fr.pederobien.uhc.conf.Spawn;

public abstract class AbstractSpawnCommand extends AbstractConfCommand {
	protected static Spawn spawn;
	
	public AbstractSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
		spawn = new Spawn();
	}
}
