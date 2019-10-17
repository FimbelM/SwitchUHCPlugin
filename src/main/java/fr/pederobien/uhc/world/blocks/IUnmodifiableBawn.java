package fr.pederobien.uhc.world.blocks;

import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.IUnmodifiableName;

public interface IUnmodifiableBawn extends IUnmodifiableName {

	void extract();

	void launch();

	void remove();

	List<ISerializableBlock> getBlocks();

	Block getCenter();

	int getWidth();

	int getHeight();

	int getDepth();
}
