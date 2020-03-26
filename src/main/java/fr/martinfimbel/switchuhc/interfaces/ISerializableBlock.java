package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

public interface ISerializableBlock {

	BlockData getBlockData();

	int getX();

	int getY();

	int getZ();

	Material getMaterial();
}
