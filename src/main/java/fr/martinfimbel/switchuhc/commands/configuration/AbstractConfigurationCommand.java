package fr.martinfimbel.switchuhc.commands.configuration;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.AbstractCommand;
import fr.martinfimbel.switchuhc.interfaces.IEditConfiguration;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableName;

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
