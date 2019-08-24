package fr.pederobien.uhc.managers;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public class WorldManager {
	private static Random rand;
	private static World world;
	private static String worldName = "world";
	private static WorldBorder border;
	
	static {
		setSpawnOnJoin(getHighestBlockYAt(0, 0).getLocation());
		rand = new Random();
		world = getWorld(worldName);
		border = world.getWorldBorder();
	}
	
	public static World getWorld(String name) {
		return Bukkit.getWorld(name);
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
	
	public static boolean isBlockTypeOf(Block block, Material...materials) {
		for (Material material : materials)
			if (isBlockTypeOf(block, material))
				return true;
		return false;
	}
	
	public static void setWorldBorderCenter(int xCenter, int zCenter) {
		border.setCenter(xCenter, zCenter);
	}
	
	public static void setWorldBorderDiameter(int diameter) {
		border.setSize(diameter);
	}
	
	public static void moveBorder(int finalDiameter, long seconds) {
		border.setSize(finalDiameter, seconds);
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
	
	public static void setSpawnOnJoin(Location spawn) {
		world.setSpawnLocation(spawn);
	}
	
	public static Location getSpawnOnRespawn() {
		return getSurfaceBlockY(getSpawnOnJoin());
	}
	
	public static double getCurrentDiameter() {
		return border.getSize();
	}
	
	public static Block getRandomlyPoint() {
		int minX = -15000000;
		int maxX = 15000000;
		int minZ = -15000000;
		int maxZ = 15000000;
		int randomX = 0;
		int randomZ = 0;
		
		if (getCurrentDiameter() > 0) {
			minX = minZ = - (int)getCurrentDiameter()/2;
			maxX = maxZ = (int)getCurrentDiameter()/2;
		}
		do {
			randomX = rand.nextInt(maxX - minX + 1) + minX;
			randomZ = rand.nextInt(maxZ - minZ + 1) + minZ;
		} while(getBelowHighestBlockYAt(randomX, randomZ).getType().equals(Material.WATER));
		return getHighestBlockYAt(randomX, randomZ);
	}
	
	public void createRespawnArea() {
		for (int x = -1; x < 2; x++)
			getBlockAt(getSpawnOnRespawn().add(new Vector(x, 0, 0))).setType(Material.BEDROCK);
		getBlockAt(getSpawnOnRespawn().add(new Vector(0, 0, 1))).setType(Material.BEDROCK);
		getBlockAt(getSpawnOnRespawn().add(new Vector(0, 0, -1))).setType(Material.BEDROCK);
	}
	
	private static Location getSurfaceBlockY(Location location) {
		Location loc = new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ());
		
		while (isBlockTypeOf(getBlockAt(loc), Material.AIR, Material.VOID_AIR))
			loc = loc.add(new Vector(0, -1, 0));
		
		return getBlockAt(loc.add(new Vector(0, 1, 0))).getLocation();
	}
}
