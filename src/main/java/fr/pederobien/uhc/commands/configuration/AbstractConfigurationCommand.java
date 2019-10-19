package fr.pederobien.uhc.commands.configuration;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.editions.IMapEdition;

public abstract class AbstractConfigurationCommand extends AbstractCommand {
	private IMapEdition conf;

	public AbstractConfigurationCommand(JavaPlugin plugin, String command, IMapEdition conf) {
		super(plugin, command, conf);
		this.conf = conf;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sendMessageToSender(sender, conf.edit(args));
		return true;
	}
}
