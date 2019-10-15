package fr.pederobien.uhc.managers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;

import fr.pederobien.uhc.world.blocks.ISpawn;

public class WorldManager {
	public static final Set<EntityType> MOBS;

	private static Random rand;
	private static World world;
	private static String worldName = "world";
	private static WorldBorder border;
	private static ISpawn spawn;
	
	static {
		rand = new Random();
		MOBS = new HashSet<>();
		world = getWorld(worldName);
		border = world.getWorldBorder();
		world.setSpawnLocation(getHighestBlockYAt(0, 0).getLocation());
		
		MOBS.add(EntityType.BLAZE);
		MOBS.add(EntityType.CREEPER);
		MOBS.add(EntityType.DROWNED);
		MOBS.add(EntityType.ELDER_GUARDIAN);
		MOBS.add(EntityType.ENDERMITE);
		MOBS.add(EntityType.EVOKER);
		MOBS.add(EntityType.GHAST);
		MOBS.add(EntityType.GUARDIAN);
		MOBS.add(EntityType.HUSK);
		MOBS.add(EntityType.MAGMA_CUBE);
		MOBS.add(EntityType.PHANTOM);
		MOBS.add(EntityType.SHULKER);
		MOBS.add(EntityType.SILVERFISH);
		MOBS.add(EntityType.SKELETON);
		MOBS.add(EntityType.SKELETON_HORSE);
		MOBS.add(EntityType.SLIME);
		MOBS.add(EntityType.SPIDER);
		MOBS.add(EntityType.STRAY);
		MOBS.add(EntityType.VEX);
		MOBS.add(EntityType.VINDICATOR);
		MOBS.add(EntityType.WITCH);
		MOBS.add(EntityType.WITHER_SKELETON);
		MOBS.add(EntityType.ZOMBIE);
		MOBS.add(EntityType.ZOMBIE_VILLAGER);
	}

	public static World getWorld(String name) {
		return Bukkit.getWorld(name);
	}

	public static World getWorld() {
		return getWorld(worldName);
	}

	public static void setPVP(boolean pvp) {
		world.setPVP(pvp);
	}

	public static Block getBlockAt(String world, int x, int y, int z) {
		return Bukkit.getWorld(world).getBlockAt(x, y, z);
	}

	public static Block getBlockAt(String world, Location location) {
		return Bukkit.getWorld(world).getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	public static Block getBlockAt(int x, int y, int z) {
		return world.getBlockAt(x, y, z);
	}

	public static Block getBlockAt(Location location) {
		return world.getBlockAt(location);
	}

	public static Block getHighestBlockYAt(int x, int z) {
		return world.getHighestBlockAt(x, z);
	}

	public static Block getBelowBlock(Block block) {
		return world.getBlockAt(block.getLocation().add(new Vector(0, -1, 0)));
	}

	public static Block getBelowHighestBlockYAt(int x, int z) {
		return getBelowBlock(getHighestBlockYAt(x, z));
	}

	public static boolean isBlockTypeOf(Block block, Material material) {
		return block.getType().equals(material);
	}

	public static boolean isBlockTypeOf(Block block, Material... materials) {
		for (Material material : materials)
			if (isBlockTypeOf(block, material))
				return true;
		return false;
	}

	public static void setWorldBorderCenter(int xCenter, int zCenter) {
		border.setCenter(xCenter, zCenter);
	}

	public static void setWorldBorderCenter(Block block) {
		border.setCenter(block.getLocation());
	}

	public static void setWorldBorderDiameter(double diameter) {
		border.setSize(diameter);
	}

	public static void moveBorder(double finalDiameter, long seconds) {
		border.setSize(finalDiameter, seconds);
	}

	public static void stopBorder() {
		border.setSize(getCurrentDiameter());
	}

	public static void removeBorder() {
		border.reset();
	}

	public static void setTime(long time) {
		world.setTime(time);
	}

	public static void setTimeDay() {
		setTime(0L);
	}

	public static void setWeather(int duration) {
		world.setWeatherDuration(duration);
	}

	public static void setWeatherSun() {
		setWeather(0);
	}

	public static Location getSpawnOnJoin() {
		return world.getSpawnLocation();
	}

	public static void setSpawn(ISpawn spawn) {
		WorldManager.spawn = spawn;
		world.setSpawnLocation(spawn.getCenter().getLocation().clone().add(new Vector(0, 1, 0)));
	}

	public static Location getSpawnOnRespawn() {
		return getSurfaceBlockY(getSpawnOnJoin());
	}

	public static Double getCurrentDiameter() {
		return border.getSize();
	}

	public static Location getRandomlyLocation(int bound) {
		int minX = -bound / 2 - 1;
		int minZ = minX;
		int maxX = bound / 2 - 1;
		int maxZ = maxX;
		int randomX = 0;
		int randomZ = 0;
		do {
			randomX = rand.nextInt(maxX - minX) + minX;
			randomZ = rand.nextInt(maxZ - minZ) + minZ;
		} while (isBlockTypeOf(getBelowHighestBlockYAt(randomX, randomZ), Material.WATER, Material.LAVA));
		return getHighestBlockYAt(randomX, randomZ).getLocation();
	}

	public static void createRespawnArea() {
		Location respawn = getSpawnOnRespawn();
		for (int x = -1; x < 2; x++)
			getBlockAt(respawn.clone().add(new Vector(x, 0, 0))).setType(Material.BEDROCK);
		getBlockAt(respawn.clone().add(new Vector(0, 0, 1))).setType(Material.BEDROCK);
		getBlockAt(respawn.clone().add(new Vector(0, 0, -1))).setType(Material.BEDROCK);
	}

	public static boolean isLocationUnderSpawn(Location location) {
		return isInInterval(location.getBlockX() - spawn.getCenter().getLocation().getBlockX(), -spawn.getWidth() / 2,
				spawn.getWidth() / 2)
				&& isInInterval(location.getBlockZ() - spawn.getCenter().getLocation().getBlockZ(),
						-spawn.getDepth() / 2, spawn.getDepth() / 2);
	}

	private static boolean isInInterval(int value, int lowerBound, int upperBound) {
		return lowerBound <= value && value <= upperBound;
	}

	private static Location getSurfaceBlockY(Location location) {
		Location loc = location.clone().add(new Vector(0, -2, 0));

		while (isBlockTypeOf(getBlockAt(loc), Material.AIR, Material.VOID_AIR))
			loc = loc.add(new Vector(0, -1, 0));

		return loc;
	}
}
