package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class PauseCommand extends AbstractGameCommand {
	private boolean pause;
	
	public PauseCommand() {
		pause = false;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!pause)
			game.pause(game.getCurrentState());
		else
			game.relaunched();
		pause = !pause;
		return true;
	}
}
