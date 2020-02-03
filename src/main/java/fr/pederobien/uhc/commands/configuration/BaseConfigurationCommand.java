package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.pederobien.uhc.interfaces.IBase;

public class BaseConfigurationCommand extends AbstractConfigurationCommand<IBase> {

	public BaseConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditBaseConfiguration());
	}
}