package fr.pederobien.uhc.commands.configuration;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.EditSpawnConfiguration;

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
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return spawnConfig.onTabComplete(sender, command, alias, args);
	}
}
