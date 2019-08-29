package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;

public abstract class AbstractConfCommand extends AbstractCommand {
	
	public AbstractConfCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}
}
