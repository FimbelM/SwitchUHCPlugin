package fr.pederobien.uhc.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.uhc.commands.AbstractCommand;
import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.managers.PlayerManager;

public class StartCommand extends AbstractCommand {

	public StartCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			if (confContext.getPlayersRegistered().count() != PlayerManager.getNumberOfPlayer())
				sendMessage((Player) sender, MessageCode.PLAYERS_NOT_IN_TEAM);
			else {
				if (confContext.initiate())
					confContext.start();
				else
					sendMessage((Player) sender, confContext.getMessage());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			sendMessage((Player) sender, MessageCode.NO_GAME_STYLE_DEFINED_AS_CURRENT);
		}
		return true;
	}
}
