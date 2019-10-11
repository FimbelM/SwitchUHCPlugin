package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.pederobien.uhc.BukkitManager;

public class PlayerManager {

	public static List<Player> getPlayers() {
		List<Player> players = new ArrayList<>();
		for (Player player : Bukkit.getOnlinePlayers())
			players.add(player);
		return players;
	}

	public static int getNumberOfPlayer() {
		return getPlayers().size();
	}

	public static Player getPlayer(String name) {
		return Bukkit.getPlayer(name);
	}

	public static void removeInventoryOfPlayers() {
		for (Player player : getPlayers())
			player.getInventory().clear();
	}

	public static void setLevelOfPlayer(Player player, int level) {
		player.setLevel(level);
	}

	public static void setLevelOfPlayers(int level) {
		for (Player player : getPlayers())
			setLevelOfPlayer(player, level);
	}

	public static void setFoodLevelOfPlayer(Player player, int level) {
		player.setFoodLevel(level);
	}

	public static void setFoodLevelOfPlayers(int level) {
		for (Player player : getPlayers())
			setFoodLevelOfPlayer(player, level);
	}

	public static void maxFoodForPlayers() {
		setFoodLevelOfPlayers(20);
	}

	public static void setMaxHealthOfPlayer(Player player, double level) {
		player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(level);
	}
	
	public static void resetMaxHealthOfPlayer(Player player) {
		setMaxHealthOfPlayer(player, 20.0);
	}
	
	public static void resetMaxHealthOfPlayers() {
		for (Player player : getPlayers())
			resetMaxHealthOfPlayer(player);
	}

	public static void setHealthOfPlayer(Player player, double level) {
		player.setHealth(level);
	}

	public static void setHealthOfPlayers(double level) {
		for (Player player : getPlayers())
			setHealthOfPlayer(player, level);
	}

	public static void maxLifeToPlayers() {
		setHealthOfPlayers(20);
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
	
	public static void setGameModeOfPlayers(List<Player> players, GameMode mode) {
		for (Player player : players)
			setGameModeOfPlayer(player, mode);
	}

	public static void setGameModeOfPlayers(GameMode mode) {
		setGameModeOfPlayers(getPlayers(), mode);
	}
	
	public static void teleporte(Player player, Location location) {
		player.teleport(location);
	}
	
	public static void teleporteAllPlayers(List<Player> players, Location location) {
		for (Player player : players)
			teleporte(player, location);
	}
	
	public static void teleporte(Player player, Entity entity) {
		player.teleport(entity);
	}
	
	public static void teleporteAllPlayers(List<Player> players, Entity entity) {
		for (Player player : players)
			teleporte(player, entity);
	}
	
	public static void teleporteAllPlayers(Location location) {
		for (Player player : getPlayers())
			teleporte(player, location);
	}

	public static void giveEffect(String selector, String effect, int duration, int power, boolean hide) {
		BukkitManager.dispatchCommand(
				"effect give " + selector + " minecraft:" + effect + " " + duration + " " + power + " " + hide);
	}

	public static void giveEffect(String selector, String effect) {
		giveEffect(selector, effect, 1, 1, false);
	}

	public static void giveEffects(String selector, String... effects) {
		for (String effect : effects)
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

	public static List<Player> getCloseCollegues(Player src, int distance) {
		return getClosePlayers(src, TeamsManager.getCollegues(src), distance);
	}

	public static List<Player> getClosePlayers(Player src, List<Player> players, int distance) {
		List<Player> nearPlayer = new ArrayList<Player>();
		int deltaX;
		int deltaY;
		int deltaZ;
		for (Player player : players) {
			deltaX = Math.abs(src.getLocation().getBlockX() - player.getLocation().getBlockX());
			deltaY = Math.abs(src.getLocation().getBlockY() - player.getLocation().getBlockY());
			deltaZ = Math.abs(src.getLocation().getBlockZ() - player.getLocation().getBlockZ());
			if (deltaX <= distance && deltaY < distance && deltaZ < distance)
				nearPlayer.add(player);
		}
		return nearPlayer;
	}
	
	public static void dropPlayerInventoryItemNaturally(Player player) {
		for (ItemStack item : player.getInventory())
			if (item != null)
				WorldManager.getWorld().dropItem(player.getLocation(), item);
		player.getInventory().clear();
	}
	
	public static void dropPlayersInventoryItemNaturally(List<Player> players) {
		for (Player player : players)
			dropPlayerInventoryItemNaturally(player);
	}
	
	public static void dropPlayersInventoryItemNaturally() {
		dropPlayersInventoryItemNaturally(getPlayers());
	}
}
