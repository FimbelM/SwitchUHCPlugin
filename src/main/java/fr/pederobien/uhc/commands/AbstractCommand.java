package fr.pederobien.uhc.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.conf.Configuration;
import fr.pederobien.uhc.conf.Persistence;

public abstract class AbstractCommand implements CommandExecutor {
	protected static Persistence persistence;
	protected static Configuration configuration;
	
	public AbstractCommand(JavaPlugin plugin, String command) {
		persistence = new Persistence();
		configuration = Configuration.DEFAULT;
		plugin.getCommand(command).setExecutor(this);
	}

	public void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player)sender).sendMessage(message);
	}
}
