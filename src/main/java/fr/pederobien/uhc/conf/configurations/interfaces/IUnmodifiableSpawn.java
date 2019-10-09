package fr.pederobien.uhc.conf.configurations.interfaces;

import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import fr.pederobien.uhc.conf.IUnmodifiableName;
import fr.pederobien.uhc.conf.Spawn.Coordinate;

public interface IUnmodifiableSpawn extends IUnmodifiableName {

	void extract();
	
	void launch();
	
	void remove();
	
	Map<Coordinate, BlockData> getBlocks();
	
	Block getCenter();
	
	int getWidth();
	
	int getHeight();
	
	int getDepth();
}
