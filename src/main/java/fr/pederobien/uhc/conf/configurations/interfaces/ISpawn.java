package fr.pederobien.uhc.conf.configurations.interfaces;

import java.util.List;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.IName;

public interface ISpawn extends IName, IUnmodifiableSpawn {

	void setBlocks(List<String> blocks);
	
	void setCenter(Block center);
	
	void setCenter(String x, String y, String z);
	
	void setDimension(String width, String height, String depth);
	
	void setDimension(int x, int y, int z);
}
