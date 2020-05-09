package fr.martinfimbel.switchuhc.commands.host;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import fr.martinfimbel.switchuhc.commands.AbstractCommand;
import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class HostCommand extends AbstractCommand implements TabCompleter {

	private Player host;
	public HostCommand(JavaPlugin plugin, String command) {
		super(plugin, command);
		this.command.setTabCompleter(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(host != null) {
			host.setOp(false);
			host.getInventory().remove(Material.COMMAND_BLOCK);
		}
		host = PlayerManager.getPlayer(args[0]);
		
		if (host == null) {
			sendMessage(createMessageEvent(sender, MessageCode.PLAYER_OFFLINE, args[0]));
			return false;
		}
		if (!host.isOp()) {
			host.setOp(true);
		}
		host.getInventory().setItemInMainHand(new ItemStack(Material.COMMAND_BLOCK));
		sendMessage(createMessageEvent(sender, MessageCode.HOST_DEFINED, host.getName()));
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return PlayerManager.getPlayers().map(player -> player.getName()).collect(Collectors.toList());
		default:
			return new ArrayList<String>();
		}
	}

}
