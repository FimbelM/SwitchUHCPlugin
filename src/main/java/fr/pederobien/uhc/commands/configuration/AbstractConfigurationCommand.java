package fr.pederobien.uhc.commands.configuration;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.IEditConfig;

public abstract class AbstractConfigurationCommand extends AbstractCommand {
	private IEditConfig conf;
	
	public AbstractConfigurationCommand(JavaPlugin plugin, String command, IEditConfig conf) {
		super(plugin, command);
		this.conf = conf;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (conf.edit(args))
			sendMessageToSender(sender, conf.getMessage());
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return conf.onTabComplete(sender, command, alias, args);

	}

}
