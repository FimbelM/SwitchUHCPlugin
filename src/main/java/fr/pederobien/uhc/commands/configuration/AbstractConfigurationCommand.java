package fr.pederobien.uhc.commands.configuration;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;

public abstract class AbstractConfigurationCommand extends AbstractCommand {
	private IMapEdition conf;
	protected CommandSender sender;

	public AbstractConfigurationCommand(JavaPlugin plugin, String command, IMapEdition conf) {
		super(plugin, command);
		this.conf = conf;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		this.sender = sender;
		sendMessageToSender(sender, conf.edit(args));
		return true;
	}

	@Override
	public List<String> abstractOnTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		this.sender = sender;
		return conf.onTabComplete(sender, command, alias, args);
	}
}
