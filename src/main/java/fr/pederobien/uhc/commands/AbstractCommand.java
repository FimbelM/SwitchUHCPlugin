package fr.pederobien.uhc.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.interfaces.IConfigurationContext;
import fr.pederobien.uhc.observer.IObsEdition;
import fr.pederobien.uhc.world.EventListener;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter, IObsEdition {
	protected static IConfigurationContext confContext;
	protected static EventListener listener;
	private int number;

	protected AbstractCommand(JavaPlugin plugin, String command) {
		plugin.getCommand(command).setExecutor(this);
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

	@Override
	final public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (!firstCall()) {
			List<String> completion = abstractOnTabComplete(sender, command, alias, args);
			return completion == null ? emptyString() : completion;
		}
		return emptyString();
	}

	@Override
	public void sendMessage(String message) {
		sendMessageToSender(BukkitManager.getDefaultCommandSender(), message);
	}

	protected List<String> abstractOnTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return emptyString();
	}

	protected List<String> emptyString() {
		return new ArrayList<String>();
	}

	private boolean firstCall() {
		if (number % 2 == 0) {
			number++;
			return true;
		} else {
			number = 0;
			return false;
		}
	}
}
