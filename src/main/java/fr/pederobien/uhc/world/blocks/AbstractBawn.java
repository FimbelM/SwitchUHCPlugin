package fr.pederobien.uhc.world.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.interfaces.IDimension;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.interfaces.IUnmodifiableDimension;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.observers.IObsBawn;

public abstract class AbstractBawn implements IBawn {
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private Block center;
	private List<ISerializableBlock> config, before;
	private String name;
	private IDimension dimension;
	private List<IObsBawn> observers;

	public AbstractBawn(String name) {
		this.name = name;
		config = new ArrayList<ISerializableBlock>();
		before = new ArrayList<ISerializableBlock>();
		dimension = new Dimension();
		observers = new ArrayList<IObsBawn>();
	}

	protected abstract void onExtraction(ISerializableBlock extractedBlock);

	@Override
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		onRenamed(oldName);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void extract() {
		config.clear();

		int maxWidth = getWidth() / 2, minWidth = -getWidth() / 2, maxDepth = getDepth() / 2, minDepth = -getDepth() / 2;
		for (int y = 0; y < getHeight(); y++)
			for (int x = minWidth; x <= maxWidth; x++)
				for (int z = minDepth; z <= maxDepth; z++) {
					ISerializableBlock block = new SerialisableBlock(x, y, z, getBlockFromCenter(x, y, z).getBlockData());
					config.add(block);
					onExtraction(block);
				}
		onExtracted();
	}

	@Override
	public void launch() {
		before.clear();
		config.stream().forEach(b -> {
			before.add(new SerialisableBlock(b, getBlockFromCenter(b).getBlockData()));
			updateBlock(b);
		});
	}

	@Override
	public void remove() {
		before.stream().forEach(b -> updateBlock(b));
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
	public IUnmodifiableDimension getDimension() {
		return dimension;
	}

	@Override
	public int getWidth() {
		return dimension.getWidth();
	}

	@Override
	public int getHeight() {
		return dimension.getHeight();
	}

	@Override
	public int getDepth() {
		return dimension.getDepth();
	}
	
	@Override
	public void addObserver(IObsBawn obs) {
		observers.add(obs);
	}
	
	@Override
	public void removeObserver(IObsBawn obs) {
		observers.remove(obs);
	}

	@Override
	public void setBlocks(List<ISerializableBlock> blocks) {
		config.clear();
		for (ISerializableBlock block : blocks)
			config.add(block);
	}

	@Override
	public void setCenter(Block center) {
		Block oldCenter = this.center;
		this.center = center;
		onRecentered(oldCenter);
	}
	
	@Override
	public void setDimension(IDimension dimension) {
		IDimension oldDimension = this.dimension;
		this.dimension = dimension;
		onRedimensioned(oldDimension);
	}

	@Override
	public void setCenter(String x, String y, String z) {
		center = WorldManager.getBlockAt(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
	}

	protected Block getBlockFromCenter(int x, int y, int z) {
		return getCenter().getRelative(x, y, z);
	}

	protected Block getBlockFromCenter(ISerializableBlock block) {
		return getBlockFromCenter(block.getX(), block.getY(), block.getZ());
	}

	private void updateBlock(ISerializableBlock block) {
		getBlockFromCenter(block).setType(block.getMaterial());
		getBlockFromCenter(block).setBlockData(block.getBlockData());
	}
	
	private void onRenamed(String oldName) {
		for (IObsBawn obs : observers)
			obs.onRenamed(oldName, name);
	}
	
	private void onExtracted() {
		for (IObsBawn obs : observers)
			obs.onExtracted(name);
	}
	
	private void onRecentered(Block oldCenter) {
		for (IObsBawn obs : observers)
			obs.onReCentered(oldCenter, center);
	}
	
	private void onRedimensioned(IUnmodifiableDimension oldDimension) {
		for (IObsBawn obs : observers)
			obs.onRedimensioned(oldDimension, dimension);
	}
}
