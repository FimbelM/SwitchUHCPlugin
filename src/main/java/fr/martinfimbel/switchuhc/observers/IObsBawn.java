package fr.martinfimbel.switchuhc.observers;

import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableDimension;

public interface IObsBawn {

	void onRenamed(String oldName, String newName);

	void onExtracted(String name);

	void onReCentered(Block oldCenter, Block newCenter);

	void onRedimensioned(IUnmodifiableDimension oldDimension, IUnmodifiableDimension newDimension);

	void onPlayerSpawnChanged(Block oldPlayerSpawn, Block newPlayerSpawn);
}
