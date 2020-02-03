package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.commands.configuration.edit.editions.EditConfigurationFactory;

public class StopCommand extends AbstractCommand {

	public StopCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		confContext.stop();
		EditConfigurationFactory.setAllAvailable(true);
		return true;
	}
}
