package fr.martinfimbel.switchuhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.martinfimbel.switchuhc.interfaces.IHungerGameConfiguration;

public class HungerGameConfigurationCommand extends AbstractConfigurationCommand<IHungerGameConfiguration> {

	public HungerGameConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command, EditConfigurationFactory.getEditHungerGameConfiguration(confContext));
	}
}