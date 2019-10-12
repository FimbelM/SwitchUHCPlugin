package fr.pederobien.uhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import fr.pederobien.uhc.conf.configurations.interfaces.ISerializableBlock;
import fr.pederobien.uhc.managers.WorldManager;

public class AbstractBawn implements IBawn {
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private Block center;
	private HashMap<Coordinate, BlockData> config;
	private int width, height, depth;
	private String name;

	public AbstractBawn(String name) {
		this.name = name;
		config = new HashMap<Coordinate, BlockData>();
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void extract() {
		config.clear();
		int maxWidth = width / 2, maxDepth = depth / 2;
		if (width % 2 == 1)
			maxWidth += 1;
		if (depth % 2 == 1)
			maxDepth += 1;

		for (int x = -width / 2; x < maxWidth; x++)
			for (int y = 0; y < height; y++)
				for (int z = -depth / 2; z < maxDepth; z++) {
					Coordinate coord = new Coordinate(x, y, z);
					config.put(coord, getBlockFromCenter(coord).getBlockData());
				}
	}

	@Override
	public void launch() {
		for (Coordinate coord : config.keySet()) {
			getBlockFromCenter(coord).setType(config.get(coord).getMaterial());
			getBlockFromCenter(coord).setBlockData(config.get(coord));
		}
	}

	@Override
	public void remove() {
		for (Coordinate coord : config.keySet())
			getBlockFromCenter(coord).setType(Material.AIR);
	}

	@Override
	public Map<Coordinate, BlockData> getBlocks() {
		return Collections.unmodifiableMap(config);
	}

	@Override
	public String toString() {
		return name + "{width=" + getWidth() + ",height=" + getHeight() + ",depth=" + getDepth() + ",center="
				+ getCenter() + "}";
	}

	@Override
	public Block getCenter() {
		return center == null ? DEFAULT_CENTER : center;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public void setBlocks(List<ISerializableBlock> blocks) {
		config.clear();
		for (ISerializableBlock block : blocks)
			addBlock(block);
	}

	@Override
	public void setCenter(Block center) {
		this.center = center;
	}

	@Override
	public void setCenter(String x, String y, String z) {
		center = WorldManager.getBlockAt(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
	}

	@Override
	public void setDimensions(String width, String height, String depth) {
		setDimensions(Integer.parseInt(width), Integer.parseInt(height), Integer.parseInt(depth));
	}

	@Override
	public void setDimensions(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	protected Block getBlockFromCenter(Coordinate coord) {
		return getCenter().getRelative(coord.getX(), coord.getY(), coord.getZ());
	}

	protected void addBlock(ISerializableBlock block) {
		config.put(new Coordinate(block.getCoordinate().getX(), block.getCoordinate().getY(),
				block.getCoordinate().getZ()), block.getBlockData());
	}
}
