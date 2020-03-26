package fr.martinfimbel.switchuhc.interfaces;

import java.util.List;

import org.bukkit.block.Block;

public interface IBawn extends IUnmodifiableBawn, IResetable {

	void setBlocks(List<ISerializableBlock> blocks);

	void setCenter(Block center);

	void setCenter(String x, String y, String z);

	void setDimension(IDimension dimension);
}
