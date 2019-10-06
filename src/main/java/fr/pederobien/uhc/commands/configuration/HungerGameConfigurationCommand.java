package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.EditHungerGameConfiguration;

public class HungerGameConfigurationCommand extends AbstractConfigurationCommand {

	public HungerGameConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, new EditHungerGameConfiguration(confContext));
	}
}
