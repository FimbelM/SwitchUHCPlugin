package fr.pederobien.uhc.commands.configuration;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.EditSpawnConfiguration;
import fr.pederobien.uhc.commands.configuration.edit.IEditConfig;

public class SpawnConfigurationCommand extends AbstractCommand {
	private IEditConfig spawnConfig;
	
	public SpawnConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
		spawnConfig = new EditSpawnConfiguration(confContext);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (spawnConfig.edit(args))
			sendMessageToSender(sender, spawnConfig.getMessage());
		else
			sendMessageToSender(sender, spawnConfig.getEditCommands());
		return false;
	}

}
