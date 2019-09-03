package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class StartCommand extends AbstractGameCommand {

	public StartCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			listener.addObservers(confContext);
			confContext.initiate();
			confContext.start();
		} catch(NullPointerException e) {
			sendMessageToSender(sender, "No game setted to be launch, use command edit to edit a new game");
		}
		return true;
	}
}
