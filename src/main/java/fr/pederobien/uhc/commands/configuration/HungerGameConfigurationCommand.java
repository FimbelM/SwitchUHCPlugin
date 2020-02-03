package fr.pederobien.uhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.pederobien.uhc.interfaces.IHungerGameConfiguration;

public class HungerGameConfigurationCommand extends AbstractConfigurationCommand<IHungerGameConfiguration> {

	public HungerGameConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditHungerGameConfiguration(confContext));
	}
}