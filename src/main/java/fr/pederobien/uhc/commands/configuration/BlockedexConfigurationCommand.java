package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.EditBlockedexConfiguration;

public class BlockedexConfigurationCommand extends AbstractConfigurationCommand {

	public BlockedexConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, new EditBlockedexConfiguration(confContext));
	}
}
