package fr.pederobien.uhc.commands.configuration;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.EditHungerGameConfiguration;

public class HungerGameConfigurationCommand extends AbstractCommand {
	private IEditConfig hungergameConfig;
	
	public HungerGameConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
		hungergameConfig = new EditHungerGameConfiguration(confContext);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (hungergameConfig.edit(args))
			sendMessageToSender(sender, hungergameConfig.getMessage());
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return hungergameConfig.onTabComplete(sender, command, alias, args);
	}
}
