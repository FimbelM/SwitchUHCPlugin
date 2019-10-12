package fr.pederobien.uhc.world.blocks;

import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import fr.pederobien.uhc.conf.IUnmodifiableName;

public interface IUnmodifiableBawn extends IUnmodifiableName {

	void extract();

	void launch();

	void remove();

	Map<Coordinate, BlockData> getBlocks();

	Block getCenter();

	int getWidth();

	int getHeight();

	int getDepth();
}
