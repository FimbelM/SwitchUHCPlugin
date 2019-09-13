package fr.pederobien.uhc.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.PluginDeposit;
import fr.pederobien.uhc.conf.IConfigurationContext;
import fr.pederobien.uhc.conf.configurations.ConfigurationContext;
import fr.pederobien.uhc.world.EventListener;
import fr.pederobien.uhc.world.IListener;

public abstract class AbstractCommand implements CommandExecutor {
	protected static IConfigurationContext confContext;
	public static IListener listener;
	
	static {
		confContext = new ConfigurationContext();
		listener = new EventListener();
		listener.addObservers(PluginDeposit.plugin);
	}
	
	public AbstractCommand(JavaPlugin plugin, String command) {
		plugin.getCommand(command).setExecutor(this);
	}

	public void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player)sender).sendMessage(message);
	}
}
