package fr.pederobien.uhc.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.world.EventListener;

public abstract class AbstractCommand implements CommandExecutor {
	protected static IConfigurationContext confContext;
	protected static EventListener listener;

	protected AbstractCommand(JavaPlugin plugin, String command, IMapEdition edition) {
		plugin.getCommand(command).setExecutor(this);
		plugin.getCommand(command).setTabCompleter(edition);
	}

	protected AbstractCommand(JavaPlugin plugin, String command) {
		plugin.getCommand(command).setExecutor(this);
		plugin.getCommand(command).setTabCompleter(new TabCompleter() {
			
			@Override
			public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
				return new ArrayList<String>();
			}
		});
	}

	public void sendMessageToSender(CommandSender sender, String message) {
		if (sender instanceof Player)
			((Player) sender).sendMessage(message);
	}

	public static void setConfigurationContext(IConfigurationContext confContext) {
		if (AbstractCommand.confContext == null)
			AbstractCommand.confContext = confContext;
	}

	public static void setListener(EventListener listener) {
		if (AbstractCommand.listener == null)
			AbstractCommand.listener = listener;
	}
}
