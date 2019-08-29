package fr.pederobien.uhc.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.conf.Spawn;

public class LaunchSpawnCommand extends AbstractSpawnCommand {

	public LaunchSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			spawn = confContext.getSpawn();
			sendMessageToSender(sender, "Spawn " + spawn.getName() + (spawn.launch() ? " loaded" : " already loaded"));
		} else {
			spawn.remove();
			Spawn sp = persistence.load(args[0]);
			if (sp != null) {
				spawn = sp;
				spawn.launch();
				sendMessageToSender(sender, "Spawn " + spawn.getName() + " loaded");
			} else
				sendMessageToSender(sender, "Spawn " + args[0] + " does not exist");
		}
		return true;
	}
}
