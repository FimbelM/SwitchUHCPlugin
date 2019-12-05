package fr.pederobien.uhc.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.dictionary.NotificationCenter;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.observers.IObsMessageSender;
import fr.pederobien.uhc.world.EventListener;

public abstract class AbstractCommand implements CommandExecutor, IObsMessageSender {
	protected static IConfigurationContext confContext;
	protected static EventListener listener;
	protected PluginCommand command;

	protected AbstractCommand(JavaPlugin plugin, String cmd) {
		command = plugin.getCommand(cmd);
		command.setExecutor(this);
		command.setTabCompleter(new TabCompleter() {

			@Override
			public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
				return new ArrayList<String>();
			}
		});
	}

	@Override
	public void sendMessage(CommandSender sender, MessageCode code) {
		NotificationCenter.sendMessage(sender, code);
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
