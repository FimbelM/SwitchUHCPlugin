package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerManager {
	public static final int MAX_EFFECT_DURATION = 999999;
	public static final int MAX_EFFECT_AMPLIFIER = 99;

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
		player.giveExpLevels(-player.getTotalExperience());
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
	
	public static void setHealthOfPlayers(List<Player> players, double level) {
		for (Player player : players)
			setHealthOfPlayer(player, level);
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

	public static void giveEffect(Player player, PotionEffect effect) {
		player.addPotionEffect(effect);
	}

	public static void giveEffect(List<Player> players, PotionEffect effect) {
		for (Player player : players)
			giveEffect(player, effect);
	}

	public static void giveEffectToAllPlayers(List<PotionEffect> effects) {
		giveEffects(getPlayers(), effects);
	}

	public static void giveEffectToAllPlayers(PotionEffectType... types) {
		giveEffects(getPlayers(), createEffect(types));
	}

	public static void giveEffects(Player player, List<PotionEffect> effects) {
		for (PotionEffect effect : effects)
			giveEffect(player, effect);
	}

	public static void giveEffects(List<Player> players, List<PotionEffect> effects) {
		for (Player player : players)
			for (PotionEffect effect : effects)
				giveEffect(player, effect);
	}

	public static PotionEffect createEffect(PotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles) {
		return new PotionEffect(type, duration, amplifier, ambient, particles);
	}

	public static PotionEffect createEffect(PotionEffectType type, int duration, int amplifier, boolean ambient) {
		return createEffect(type, duration, amplifier, ambient, true);
	}

	public static PotionEffect createEffect(PotionEffectType type, int duration, int amplifier) {
		return createEffect(type, duration, amplifier, true);
	}

	public static PotionEffect createEffect(PotionEffectType type) {
		return createEffect(type, 20, 1);
	}

	public static List<PotionEffect> createEffect(PotionEffectType... types) {
		List<PotionEffect> effects = new ArrayList<PotionEffect>();
		for (PotionEffectType type : types)
			effects.add(createEffect(type));
		return effects;
	}

	public static void giveEffectToPlayerOnMode(GameMode mode, PotionEffect effect) {
		giveEffect(getPlayersOnMode(mode), effect);
	}

	public static void giveEffectsToPlayerOnMode(GameMode mode, List<PotionEffect> effects) {
		giveEffects(getPlayersOnMode(mode), effects);
	}

	public static void removeEffect(Player player, PotionEffectType type) {
		player.removePotionEffect(type);
	}

	public static void removeEffect(List<Player> players, PotionEffectType type) {
		for (Player player : players)
			removeEffect(player, type);
	}

	public static void removeEffect(Player player, List<PotionEffectType> types) {
		for (PotionEffectType type : types)
			removeEffect(player, type);
	}

	public static void removeEffect(List<Player> players, List<PotionEffectType> types) {
		for (Player player : players)
			for (PotionEffectType type : types)
				removeEffect(player, type);
	}

	public static void removeAllEffects(Player player) {
		Collection<PotionEffect> activeEffects = player.getActivePotionEffects();
		for (PotionEffect effect : activeEffects)
			player.removePotionEffect(effect.getType());
	}

	public static void removeAllEffectsToAllPlayers() {
		for (Player player : getPlayers())
			removeAllEffects(player);
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
				player.getLocation().getWorld().dropItem(player.getLocation(), item);
		player.getInventory().clear();
	}

	public static void dropPlayersInventoryItemNaturally(List<Player> players) {
		for (Player player : players)
			dropPlayerInventoryItemNaturally(player);
	}

	public static void dropPlayersInventoryItemNaturally() {
		dropPlayersInventoryItemNaturally(getPlayers());
	}
	
	public static void sendMessageToPlayers(List<Player> players, String message) {
		for (Player player : players)
			player.sendMessage(message);
	}
	
	public static void killPlayer(Player player) {
		setHealthOfPlayer(player, 0);
	}
	
	public static void killPlayers(List<Player> players) {
		setHealthOfPlayers(players, 0);
	}
}
