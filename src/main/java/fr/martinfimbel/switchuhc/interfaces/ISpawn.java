package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.block.Block;

public interface ISpawn extends IUnmodifiableSpawn, IBawn {

	void setPlayerSpawn(Block playerSpawn);

	void setPlayerSpawn(String x, String y, String z);

	void setPlayerSpawnRelativeToCenter(String x, String y, String z);
}
