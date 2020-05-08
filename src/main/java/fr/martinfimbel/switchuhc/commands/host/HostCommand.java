package fr.martinfimbel.switchuhc.commands.host;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.BukkitManager;
import fr.martinfimbel.switchuhc.commands.AbstractCommand;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.managers.PlayerManager;

public class HostCommand extends AbstractCommand {

	public HostCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player playerHosting = PlayerManager.getPlayer(args[0]);
		if (!playerHosting.isOnline()) {
			sendMessage(createMessageEvent(sender, MessageCode.PLAYERS_NOT_ONLINE));
			return false;
		}
		if (!playerHosting.isOp()) {
			BukkitManager.dispatchCommand("op " + playerHosting);
			BukkitManager.dispatchCommand("give " + playerHosting + " minecraft:command_block");
		}
		return true;
	}

}
