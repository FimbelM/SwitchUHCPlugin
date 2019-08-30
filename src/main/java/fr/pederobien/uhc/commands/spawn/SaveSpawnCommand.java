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
			spawnPersistence.save();
			sendMessageToSender(sender, "Spawn " + getSpawn().getName() + " saved.");
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, "Il n'y a pas assez d'arguments");
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, "Impossible de définir le centre du spawn");
		}
		return false;
	}
}
