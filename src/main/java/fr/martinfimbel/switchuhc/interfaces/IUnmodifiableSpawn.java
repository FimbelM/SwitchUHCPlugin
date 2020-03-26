package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.block.Block;

public interface IUnmodifiableSpawn extends IUnmodifiableBawn {

	Block getPlayerSpawn();

	ISerializableBlock getPlayerSpawnRelativeToCenter();

}
