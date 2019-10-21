package fr.pederobien.uhc.observer;

import org.bukkit.block.Block;

import fr.pederobien.uhc.interfaces.IUnmodifiableDimension;

public interface IObsBawn {

	void onRenamed(String oldName, String newName);
	
	void onExtracted(String name);
	
	void onReCentered(Block oldCenter, Block newCenter);
	
	void onRedimensioned(IUnmodifiableDimension oldDimension, IUnmodifiableDimension newDimension);
}
