package fr.martinfimbel.switchuhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;

public class SpawnConfigurationCommand extends AbstractConfigurationCommand<ISpawn> {

	public SpawnConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditSpawnConfiguration());
	}
}