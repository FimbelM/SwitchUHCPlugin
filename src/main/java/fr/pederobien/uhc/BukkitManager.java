package fr.pederobien.uhc;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class BukkitManager {
	
	public static void dispatchCommand(CommandSender sender, String command) {
		Bukkit.getServer().dispatchCommand(sender, command);
	}
	
	public static void dispatchCommand(String command) {
		dispatchCommand(Bukkit.getConsoleSender(), command);
	}
}
