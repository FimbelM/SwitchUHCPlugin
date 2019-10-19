package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.EditBaseConfiguration;

public class BaseConfigurationCommand extends AbstractConfigurationCommand {

	public BaseConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, new EditBaseConfiguration(confContext));
	}
}