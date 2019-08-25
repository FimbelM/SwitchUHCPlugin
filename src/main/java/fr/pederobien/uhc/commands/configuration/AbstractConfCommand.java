package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.conf.Persistence;

public abstract class AbstractConfCommand extends AbstractCommand {
	protected static Persistence persistence = new Persistence();
	
	public AbstractConfCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
}
