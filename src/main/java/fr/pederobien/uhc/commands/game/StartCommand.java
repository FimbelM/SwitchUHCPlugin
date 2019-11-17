package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.managers.PlayerManager;

public class StartCommand extends AbstractCommand {

	public StartCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			if (confContext.getPlayersRegistered().count() != PlayerManager.getNumberOfPlayer())
				sendMessageToSender(sender, "There are players that are not in a team");
			else {
				if (confContext.initiate())
					confContext.start();
				else
					sendMessageToSender(sender, confContext.getMessage());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			sendMessageToSender(sender, "No game setted to be launch, use command edit to edit a new game");
		}
		return true;
	}
}
