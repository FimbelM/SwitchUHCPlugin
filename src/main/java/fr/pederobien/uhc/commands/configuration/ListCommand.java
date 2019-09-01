package fr.pederobien.uhc.commands.configuration;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ListCommand extends AbstractConfigurationCommand {

	public ListCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		switch (args[0]) {
		case "hungergame":
			sendMessageToSender(sender, prepare(hgPersistence.list()));
			break;
		case "spawn":
			sendMessageToSender(sender, prepare(spPersistence.list()));
			break;
		default:
			break;
		}
		return false;
	}
	
	private String prepare(List<String> list) {
		StringBuilder builder = new StringBuilder();
		for (String str : list)
			builder.append(str.concat("\r\n"));
		return builder.toString();
	}
}
