package fr.pederobien.uhc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;

public class BukkitManager {

	public static Collection<? extends Player> getOnlinePlayers() {
		return Bukkit.getOnlinePlayers();
	}

	public static OfflinePlayer[] getOfflinePlayers() {
		return Bukkit.getOfflinePlayers();
	}

	public static Player getPlayer(String name) {
		return Bukkit.getPlayer(name);
	}

	public static void dispatchCommand(CommandSender sender, String command) {
		Bukkit.getServer().dispatchCommand(sender, command);
	}

	public static void dispatchCommand(String command) {
		dispatchCommand(Bukkit.getConsoleSender(), command);
	}

	public static BlockData createBlockData(String data) {
		return Bukkit.createBlockData(data);
	}

	public static void broadcastMessageAsTitle(String message) {
		dispatchCommand("title @a title " + "{\"text\":\"" + message + "\"}");
	}

	public static void broadcastMessageAsTitle(String message, String color) {
		dispatchCommand("title @a title " + "{\"text\":\"" + message + "\",\"color\":\"" + color + "\"}");
	}

	public static void broadcastMessage(String message) {
		Bukkit.broadcastMessage(message);
	}

	public static CommandSender getDefaultCommandSender() {
		return Bukkit.getConsoleSender();
	}

	public static ScoreboardManager getScoreboardManager() {
		return Bukkit.getScoreboardManager();
	}

	public static World getWorld(String name) {
		return Bukkit.getWorld(name);
	}

	public static List<OfflinePlayer> getOperators() {
		return new ArrayList<OfflinePlayer>(Bukkit.getServer().getOperators());
	}

	public static Stream<Player> getOnlineOperators() {
		return getOperators().stream().map(p -> p.getPlayer()).filter(p -> p != null);
	}
}
