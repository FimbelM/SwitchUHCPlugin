package fr.martinfimbel.switchuhc.commands.configuration;

import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.configuration.edit.editions.EditConfigurationFactory;
import fr.martinfimbel.switchuhc.interfaces.ISwitchGameConfiguration;

public class SwitchConfigurationCommand extends AbstractConfigurationCommand<ISwitchGameConfiguration>{

		public SwitchConfigurationCommand(JavaPlugin plugin, String command) {
			super(plugin, command, EditConfigurationFactory.getEditSwConfiguration(confContext));
		}
}
