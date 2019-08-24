package fr.pederobien.uhc.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.conf.Persistence;

public abstract class AbstractCommand implements CommandExecutor {
	protected Persistence persistence;
	
	public AbstractCommand() {
		persistence = new Persistence();
	}

	public void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player)sender).sendMessage(message);
	}
}
