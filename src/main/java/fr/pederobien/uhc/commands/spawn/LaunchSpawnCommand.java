package fr.pederobien.uhc.commands.spawn;

import java.io.FileNotFoundException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class LaunchSpawnCommand extends AbstractSpawnCommand {

	public LaunchSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			confContext.setSpawn(getSpawn());
			sendMessageToSender(sender, "Spawn " + getSpawn().getName() + (getSpawn().launch() ? " loaded" : " already loaded"));
		} else {
			getSpawn().remove();
			try {
				spawnPersistence.load(args[0]);
				sendMessageToSender(sender, "Spawn " + getSpawn().getName() + " loaded");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				sendMessageToSender(sender, "Spawn " + args[0] + " does not exist");
			}
		}
		return true;
	}
}
