package fr.pederobien.uhc.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveSpawnCommand extends AbstractSpawnCommand {

	public SaveSpawnCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			spawn.setName(args[0]);
			spawn.setCenter(args[1], args[2], args[3]);
			spawn.setDimension(args[4], args[5], args[6]);
			spawn.extract();
			persistence.persisteSpawn(spawn);
			sendMessageToSender(sender, "Spawn " + spawn.getName() + " saved.");
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, "Il n'y a pas assez d'arguments");
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, "Impossible de définir le centre du spawn");
		}
		return false;
	}
}
