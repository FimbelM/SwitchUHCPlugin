package fr.pederobien.uhc.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.dictionary.NotificationCenter;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.MessageEvent;
import fr.pederobien.uhc.interfaces.ICommand;
import fr.pederobien.uhc.interfaces.IConfigurationContext;

public abstract class AbstractCommand implements ICommand {
	protected static IConfigurationContext confContext;
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
	public void sendMessage(MessageEvent event) {
		NotificationCenter.sendMessage(event);
	}

	public static void setConfigurationContext(IConfigurationContext confContext) {
		if (AbstractCommand.confContext == null)
			AbstractCommand.confContext = confContext;
	}

	protected MessageEvent createMessageEvent(CommandSender sender, MessageCode code, String... args) {
		return EventFactory.createMessageEvent(sender, code, args);
	}
}
