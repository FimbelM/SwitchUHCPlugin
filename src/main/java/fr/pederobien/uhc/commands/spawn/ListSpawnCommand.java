package fr.pederobien.uhc.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ListSpawnCommand extends AbstractSpawnCommand {

	public ListSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToSender(sender, spawnPersistence.getSpawnsName());
		return false;
	}

}
