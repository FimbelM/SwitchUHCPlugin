package fr.pederobien.uhc.conf.configurations;

import org.bukkit.block.data.BlockData;

import fr.pederobien.uhc.BukkitManager;
import fr.pederobien.uhc.conf.configurations.interfaces.ISerializableBlock;
import fr.pederobien.uhc.world.blocks.Coordinate;

public class SerialisableBlock implements ISerializableBlock {
	private Coordinate coordinate;
	private BlockData data;

	public SerialisableBlock(int x, int y, int z, BlockData blockData) {
		coordinate = new Coordinate(x, y, z);
		this.data = blockData;
	}

	public SerialisableBlock(int x, int y, int z, String blockData) {
		this(x, y, z, BukkitManager.createBlockData(blockData));
	}

	public SerialisableBlock(String x, String y, String z, String blockData) {
		this(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z), BukkitManager.createBlockData(blockData));
	}

	@Override
	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public BlockData getBlockData() {
		return data;
	}
	
	@Override
	public String toString() {
		return coordinate + data.getAsString();
	}
}
