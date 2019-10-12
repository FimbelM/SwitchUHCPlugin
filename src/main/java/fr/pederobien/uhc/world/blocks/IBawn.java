package fr.pederobien.uhc.world.blocks;

import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.IName;
import fr.pederobien.uhc.conf.configurations.interfaces.ISerializableBlock;

public interface IBawn extends IName, IUnmodifiableBawn {

	void setBlocks(List<ISerializableBlock> blocks);

	void setCenter(Block center);

	void setCenter(String x, String y, String z);

	void setDimensions(String width, String height, String depth);

	void setDimensions(int width, int height, int depth);
	
	String getDefault();
}
