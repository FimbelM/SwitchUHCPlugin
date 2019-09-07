package fr.pederobien.uhc.conf;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import fr.pederobien.uhc.managers.WorldManager;

public class Spawn {
	public static final Spawn DEFAULT;
	private static final Block DEFAULT_CENTER;
	private Block center;
	private HashMap<Coordinate, Material> config;
	private int width, height, depth;
	private String name;

	static {
		DEFAULT = new Spawn("DefaultSpawn");
		DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
		DEFAULT.setDimension(5, 1, 5);
		
		DEFAULT.uniformSpawn(Material.BEDROCK);
	}

	public Spawn(String name) {
		config = new HashMap<Coordinate, Material>();
		this.name = name;
	}

	public void extract() {
		config.clear();
		int maxWidth = width / 2, maxDepth = depth / 2;
		if (width % 2 == 1)
			maxWidth += 1;
		if (depth % 2 == 1)
			maxDepth += 1;

		for (int x = -width / 2; x < maxWidth; x++)
			for (int y = 0; y < height; y++)
				for (int z = -depth / 2; z < maxDepth; z++)
					config.put(new Coordinate(x, y, z), getBlockFromCenter(x, y, z).getType());
	}

	public void launch() {
		for (Coordinate coord : config.keySet())
			getBlockFromCenter(coord.getX(), coord.getY(), coord.getZ()).setType(config.get(coord));
		WorldManager.setSpawnOnJoin(center.getLocation().clone().add(new Vector(0, 1, 0)));
	}

	public void remove() {
		for (Coordinate coord : config.keySet())
			getBlockFromCenter(coord.getX(), coord.getY(), coord.getZ()).setType(Material.AIR);
	}

	public void setBlocks(List<String> blocks) {
		config.clear();
		for (String block : blocks)
			addBlock(block);
	}

	private void addBlock(String block) {
		String[] info = block.split(";");
		int x = Integer.parseInt(info[0]);
		int y = Integer.parseInt(info[1]);
		int z = Integer.parseInt(info[2]);
		Material material = Material.valueOf(info[3]);
		getBlockFromCenter(x, y, z).setType(material);
		config.put(new Coordinate(x, y, z), getBlockFromCenter(x, y, z).getType());
	}

	public Map<Coordinate, Material> getBlocks() {
		return Collections.unmodifiableMap(config);
	}

	@Override
	public String toString() {
		return name;
	}

	public Block getCenter() {
		return center == null ? DEFAULT_CENTER : center;
	}

	public void setCenter(Block center) {
		this.center = center;
	}

	public void setCenter(String x, String y, String z) {
		center = WorldManager.getBlockAt(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
	}

	public void setDimension(String width, String height, String depth) {
		setDimension(Integer.parseInt(width), Integer.parseInt(height), Integer.parseInt(depth));
	}

	public void setDimension(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDepth() {
		return depth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Block getBlockFromCenter(int x, int y, int z) {
		return WorldManager.getBlockAt(getCenter().getX() + x, getCenter().getY() + y, getCenter().getZ() + z);
	}
	
	private void uniformSpawn(Material material) {
		int maxWidth = DEFAULT.width / 2, maxDepth = DEFAULT.depth / 2;
		if (DEFAULT.width % 2 == 1)
			maxWidth += 1;
		if (DEFAULT.depth % 2 == 1)
			maxDepth += 1;

		for (int x = -DEFAULT.width / 2; x < maxWidth; x++)
			for (int y = 0; y < DEFAULT.height; y++)
				for (int z = -DEFAULT.depth / 2; z < maxDepth; z++)
					DEFAULT.config.put(new Coordinate(x, y, z), material);
	}

	public class Coordinate {
		private int x, y, z;

		public Coordinate(int x, int y, int z) {
			this.setX(x);
			this.setY(y);
			this.setZ(z);
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getZ() {
			return z;
		}

		public void setZ(int z) {
			this.z = z;
		}
	}
}
