package fr.pederobien.uhc.commands.spawn;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.xml.sax.SAXException;

public class SaveSpawnCommand extends AbstractSpawnCommand {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			spawn.setName(args[0]);
			spawn.setCenter(args[1], args[2], args[3]);
			spawn.setDimension(args[4], args[5], args[6]);
			spawn.extract();
			if (persistence.persisteSpawn(spawn))
				sendMessageToSender(sender, "Spawn " + spawn.getName() + " saved.");
			else
				sendMessageToSender(sender, "This spawn already exist, use command \"updatespawn\"");
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, "Il n'y a pas assez d'arguments");
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, "Impossible de définir le centre du spawn");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
