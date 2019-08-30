package fr.pederobien.uhc.commands.configuration.hungergame;

import java.io.FileNotFoundException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class LaunchHungerGameCommand extends AbstractHungerGameCommand {

	public LaunchHungerGameCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			confContext.setCurrentConfiguration(getConfiguration());
			sendMessageToSender(sender, "Configuration " + getConfiguration().getName() + " as current configuration");
		} else {
			hungergamePersistence.save();
			try {
				hungergamePersistence.load(args[0]);
				confContext.setCurrentConfiguration(getConfiguration());
				sendMessageToSender(sender, "Configuration " + getConfiguration().getName() + " as current configuration");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				sendMessageToSender(sender, "Spawn " + args[0] + " does not exist");
			}
		}
		return false;
	}
}
