package fr.pederobien.uhc.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.world.EventListener;

public abstract class AbstractCommand implements CommandExecutor {
	protected static ConfigurationContext confContext = new ConfigurationContext();

	public static EventListener listener = new EventListener();
	
	public AbstractCommand(JavaPlugin plugin, String command) {
		plugin.getCommand(command).setExecutor(this);
	}

	public void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player)sender).sendMessage(message);
	}
}
