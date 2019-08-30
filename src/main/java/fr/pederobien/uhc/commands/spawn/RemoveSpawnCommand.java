package fr.pederobien.uhc.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoveSpawnCommand extends AbstractSpawnCommand {

	public RemoveSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToSender(sender,
				"Spawn " + getSpawn().getName() + (getSpawn().remove() ? " removed" : " already removed"));
		return false;
	}
}
