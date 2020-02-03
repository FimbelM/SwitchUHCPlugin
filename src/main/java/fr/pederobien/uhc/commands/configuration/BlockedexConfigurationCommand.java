package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.pederobien.uhc.interfaces.IBlockedexConfiguration;

public class BlockedexConfigurationCommand extends AbstractConfigurationCommand<IBlockedexConfiguration> {

	public BlockedexConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditBlockedexConfiguration(confContext));
	}
}
