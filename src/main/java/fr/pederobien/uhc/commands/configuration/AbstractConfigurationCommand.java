package fr.pederobien.uhc.commands.configuration;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.interfaces.IEditConfiguration;
import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public abstract class AbstractConfigurationCommand<T extends IUnmodifiableName> extends AbstractCommand {
	private IEditConfiguration<T> configuration;

	public AbstractConfigurationCommand(JavaPlugin plugin, String cmd, IEditConfiguration<T> conf) {
		super(plugin, cmd);
		configuration = conf;
		command.setTabCompleter(configuration);
		configuration.addObserver(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		configuration.edit(sender, args);
		return true;
	}
}
