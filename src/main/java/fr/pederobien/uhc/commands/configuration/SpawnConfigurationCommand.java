package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.EditSpawnConfiguration;
import fr.pederobien.uhc.interfaces.ISpawn;

public class SpawnConfigurationCommand extends AbstractConfigurationCommand<ISpawn> {

	public SpawnConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, new EditSpawnConfiguration());
	}
}