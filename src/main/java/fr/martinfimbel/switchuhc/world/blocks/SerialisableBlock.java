package fr.martinfimbel.switchuhc.world.blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

import fr.martinfimbel.switchuhc.BukkitManager;
import fr.martinfimbel.switchuhc.interfaces.ISerializableBlock;
import fr.martinfimbel.switchuhc.managers.WorldManager;

public class SerialisableBlock implements ISerializableBlock {
	private Location loc;
	private BlockData data;

	public SerialisableBlock(int x, int y, int z, BlockData blockData) {
		loc = WorldManager.createDefaultLocation(x, y, z);
		this.data = blockData;
	}

	public SerialisableBlock(int x, int y, int z, String blockData) {
		this(x, y, z, BukkitManager.createBlockData(blockData));
	}

	public SerialisableBlock(ISerializableBlock block, BlockData data) {
		loc = WorldManager.createDefaultLocation(block.getX(), block.getY(), block.getZ());
		this.data = data;
	}

	public SerialisableBlock(String x, String y, String z, String blockData) {
		this(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z), BukkitManager.createBlockData(blockData));
	}

	@Override
	public BlockData getBlockData() {
		return data;
	}

	@Override
	public int getX() {
		return loc.getBlockX();
	}

	@Override
	public int getY() {
		return loc.getBlockY();
	}

	@Override
	public int getZ() {
		return loc.getBlockZ();
	}

	@Override
	public Material getMaterial() {
		return data.getMaterial();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass())
			return false;
		else {
			SerialisableBlock block = (SerialisableBlock) obj;
			return getX() == block.getX() && getY() == block.getY() && getZ() == block.getZ() && getMaterial() == block.getMaterial();
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{x=" + getX() + ",y=" + getY() + ",z=" + getZ() + ",blockData=" + data + "}";
	}
}
