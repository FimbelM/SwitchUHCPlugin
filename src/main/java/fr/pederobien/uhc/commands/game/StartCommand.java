package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StartCommand extends AbstractGameCommand {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		game.start();
		return true;
	}
}
