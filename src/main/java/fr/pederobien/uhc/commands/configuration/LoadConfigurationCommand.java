package fr.pederobien.uhc.commands.configuration;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;

public class LoadConfigurationCommand extends AbstractCommand {

	public LoadConfigurationCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		configuration = persistence.loadConfiguration(args[0]);
		sendMessageToSender(sender,
				"Configuration " + args[0] + configuration == null ? " does not exist" : " launched");
		return false;
	}

}
