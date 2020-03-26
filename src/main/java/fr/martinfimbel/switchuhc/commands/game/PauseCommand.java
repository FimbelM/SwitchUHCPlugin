package fr.martinfimbel.switchuhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.AbstractCommand;

public class PauseCommand extends AbstractCommand {
	private boolean pause = false;

	public PauseCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!pause)
			confContext.pause();
		else
			confContext.relaunch();
		pause = !pause;
		return true;
	}
}
