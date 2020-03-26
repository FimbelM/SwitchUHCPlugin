package fr.martinfimbel.switchuhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.martinfimbel.switchuhc.interfaces.IBlockedexConfiguration;

public class BlockedexConfigurationCommand extends AbstractConfigurationCommand<IBlockedexConfiguration> {

	public BlockedexConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditBlockedexConfiguration(confContext));
	}
}
