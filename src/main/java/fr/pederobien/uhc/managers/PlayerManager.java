package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.BukkitManager;

public class PlayerManager {
	
	public static List<Player> getPlayers() {
		List<Player> players = new ArrayList<>();
		for (Player player : Bukkit.getOnlinePlayers())
			players.add(player);
		return players;
	}
	
	public static Player getPlayer(String name) {
		return Bukkit.getPlayer(name);
	}
	
	public static void removeInventoryOfPlayers() {
		for (Player player : getPlayers())
			player.getInventory().clear();
	}
	
	public static void setLevelOfPlayers(int level) {
		for (Player player : getPlayers())
			player.setLevel(level);
	}
	
	public static void setFoodLevelOfPlayers(int level) {
		for (Player player : getPlayers())
			player.setFoodLevel(level);
	}
	
	public static List<Player> getPlayersOnMode(GameMode mode) {
		List<Player> players = new ArrayList<Player>();
		for (Player player : getPlayers())
			if (player.getGameMode().equals(mode))
				players.add(player);
		return players;
	}

	public static int getNumberOfPlayersOnMode(GameMode mode) {
		return getPlayersOnMode(mode).size();
	}
	
	public static void setGameModeOfPlayer(Player player, GameMode mode) {
		player.setGameMode(mode);
	}
	
	public static void setGameModeOfPlayers(GameMode mode) {
		for (Player player : getPlayers())
			player.setGameMode(mode);
	}

	public static void giveEffect(String selector, String effect, int duration, int power, boolean hide) {
		BukkitManager.dispatchCommand(
				"effect give " + selector + " minecraft:" + effect + " " + duration + " " + power + " " + hide);
	}

	public static void giveEffect(String selector, String effect) {
		giveEffect(selector, effect, 1, 1, false);
	}

	public static void giveEffectToPlayerOnMode(GameMode mode, String effect) {
		for (Player player : getPlayersOnMode(mode))
			giveEffect(player.getName(), effect, 999999, 99, true);
	}

	public static void giveEffectToPlayerOnMode(GameMode mode, String... effects) {
		for (Player player : getPlayersOnMode(mode))
			for (String effect : effects)
				giveEffect(player.getName(), effect, 999999, 99, true);
	}

	public static void clearEffect(String selector, String effect) {
		BukkitManager.dispatchCommand("effect clear " + selector + " minecraft:" + effect);
	}

	public static void clearEffectToPlayerOnMode(GameMode mode, String effect) {
		for (Player player : getPlayersOnMode(mode))
			clearEffect(player.getName(), effect);
	}

	public static void clearEffectToPlayerOnMode(GameMode mode, String... effects) {
		for (Player player : getPlayersOnMode(mode))
			for (String effect : effects)
				clearEffect(player.getName(), effect);
	}
}
