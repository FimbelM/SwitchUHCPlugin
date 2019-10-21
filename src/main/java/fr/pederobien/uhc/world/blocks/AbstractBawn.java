package fr.pederobien.uhc.world.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.managers.WorldManager;

public abstract class AbstractBawn implements IBawn {
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private Block center;
	private List<ISerializableBlock> config, before;
	private int width, height, depth;
	private String name;

	public AbstractBawn(String name) {
		this.name = name;
		config = new ArrayList<ISerializableBlock>();
		before = new ArrayList<ISerializableBlock>();
	}

	protected abstract void onExtraction(ISerializableBlock extractedBlock);

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
		for (int y = 0; y < height; y++)
			for (int x = -width / 2; x < getMax(width); x++)
				for (int z = -depth / 2; z < getMax(depth); z++) {
					ISerializableBlock block = new SerialisableBlock(x, y, z,
							getBlockFromCenter(x, y, z).getBlockData());
					config.add(block);
					onExtraction(block);
				}
	}

	@Override
	public void launch() {
		for (ISerializableBlock block : config) {
			before.add(new SerialisableBlock(block, getBlockFromCenter(block).getBlockData()));
			updateBlock(block);
		}
	}

	@Override
	public void remove() {
		for (ISerializableBlock block : before)
			updateBlock(block);
	}

	@Override
	public List<ISerializableBlock> getBlocks() {
		return Collections.unmodifiableList(config);
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
			config.add(block);
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

	protected Block getBlockFromCenter(int x, int y, int z) {
		return getCenter().getRelative(x, y, z);
	}

	protected Block getBlockFromCenter(ISerializableBlock block) {
		return getCenter().getRelative(block.getX(), block.getY(), block.getZ());
	}

	protected void clearBlocks() {
		config.clear();
	}

	protected int getMax(int value) {
		int max = value / 2;
		return max % 2 == 1 ? max + 1 : max;
	}

	private void updateBlock(ISerializableBlock block) {
		getBlockFromCenter(block).setType(block.getMaterial());
		getBlockFromCenter(block).setBlockData(block.getBlockData());
	}
}
