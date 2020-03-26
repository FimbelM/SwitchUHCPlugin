package fr.martinfimbel.switchuhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.martinfimbel.switchuhc.interfaces.IBase;

public class BaseConfigurationCommand extends AbstractConfigurationCommand<IBase> {

	public BaseConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditBaseConfiguration());
	}
}