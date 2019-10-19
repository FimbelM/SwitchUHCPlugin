package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.EditSpawnConfiguration;

public class SpawnConfigurationCommand extends AbstractConfigurationCommand {

	public SpawnConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, new EditSpawnConfiguration(confContext));
	}
}