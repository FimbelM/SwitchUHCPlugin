package fr.pederobien.uhc.conf.configurations.interfaces;

import org.bukkit.block.data.BlockData;

import fr.pederobien.uhc.world.blocks.Coordinate;

public interface ISerializableBlock {

	Coordinate getCoordinate();
	
	BlockData getBlockData();
}
