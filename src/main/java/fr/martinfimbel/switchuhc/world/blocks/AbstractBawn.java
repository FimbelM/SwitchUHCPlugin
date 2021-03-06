package fr.martinfimbel.switchuhc.world.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.interfaces.IBawn;
import fr.martinfimbel.switchuhc.interfaces.IDimension;
import fr.martinfimbel.switchuhc.interfaces.ISerializableBlock;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableDimension;
import fr.martinfimbel.switchuhc.managers.WorldManager;
import fr.martinfimbel.switchuhc.observers.IObsBawn;

public abstract class AbstractBawn implements IBawn {
	private static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(0, 0);
	private static final IDimension DEFAULT_DIMENSION = new Dimension();
	private Block center;
	private List<ISerializableBlock> config, before;
	private String name;
	private IDimension dimension;
	protected List<IObsBawn> observers;

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
		if (before.isEmpty())
			config.stream().forEach(b -> before.add(new SerialisableBlock(b, Material.AIR.createBlockData())));
		before.stream().forEach(b -> updateBlock(b));
	}

	@Override
	public List<ISerializableBlock> getBlocks() {
		return Collections.unmodifiableList(config);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Name : " + getName() + "\n");
		builder.append("Center : " + showBlock(getCenter()) + "\n");
		builder.append("Width : " + getWidth() + " blocks\n");
		builder.append("Height : " + getHeight() + " blocks\n");
		builder.append("Depth : " + getDepth() + " blocks\n");
		return builder.toString();
	}

	@Override
	public Block getCenter() {
		return center == null ? DEFAULT_CENTER : center;
	}

	@Override
	public IUnmodifiableDimension getDimension() {
		return dimension == null ? DEFAULT_DIMENSION : dimension;
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
	public void reset() {
		setCenter(null);
		setDimension(null);
		config.clear();
		before.clear();
	}

	@Override
	public void setCenter(String x, String y, String z) {
		setCenter(WorldManager.getBlockAt(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z)));
	}

	protected Block getBlockFromCenter(int x, int y, int z) {
		return getCenter().getRelative(x, y, z);
	}

	protected Block getBlockFromCenter(ISerializableBlock block) {
		return getBlockFromCenter(block.getX(), block.getY(), block.getZ());
	}

	protected ISerializableBlock getRelativeBlockFromTheWorld(Block block) {
		return new SerialisableBlock(block.getX() - getCenter().getX(), block.getY() - getCenter().getY(), block.getZ() - getCenter().getZ(),
				block.getBlockData());
	}

	protected String showBlock(Block block) {
		return "X=" + block.getX() + " Y=" + block.getY() + " Z=" + block.getZ();
	}

	private void updateBlock(ISerializableBlock block) {
		getBlockFromCenter(block).setType(block.getMaterial());
		getBlockFromCenter(block).setBlockData(block.getBlockData());
	}

	private void onRenamed(String oldName) {
		for (IObsBawn obs : observers)
			obs.onRenamed(oldName, getName());
	}

	private void onExtracted() {
		for (IObsBawn obs : observers)
			obs.onExtracted(getName());
	}

	private void onRecentered(Block oldCenter) {
		for (IObsBawn obs : observers)
			obs.onReCentered(oldCenter, getCenter());
	}

	private void onRedimensioned(IUnmodifiableDimension oldDimension) {
		for (IObsBawn obs : observers)
			obs.onRedimensioned(oldDimension, getDimension());
	}
}
