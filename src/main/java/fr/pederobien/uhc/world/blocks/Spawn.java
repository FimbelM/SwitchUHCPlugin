package fr.pederobien.uhc.world.blocks;

import org.bukkit.block.Block;

import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.interfaces.ISpawn;
import fr.pederobien.uhc.managers.WorldManager;
import fr.pederobien.uhc.observers.IObsBawn;

public class Spawn extends AbstractBawn implements ISpawn {
	private static final Block DEFAULT_PLAYER_SPAWN = WorldManager.getHighestBlockYAt(0, 0);

	private Block playerSpawn;

	public Spawn(String name) {
		super(name);
	}

	@Override
	protected void onExtraction(ISerializableBlock extractedBlock) {

	}

	@Override
	public void launch() {
		super.launch();
		WorldManager.setSpawn(this);
	}

	@Override
	public void remove() {
		super.remove();
		WorldManager.setSpawn(null);
	}

	@Override
	public Block getPlayerSpawn() {
		return playerSpawn == null ? DEFAULT_PLAYER_SPAWN : playerSpawn;
	}

	@Override
	public void setPlayerSpawn(Block playerSpawn) {
		Block oldPlayerSpawn = this.playerSpawn;
		this.playerSpawn = playerSpawn;
		onPlayerSpawnChanged(oldPlayerSpawn);
	}

	private void onPlayerSpawnChanged(Block oldPlayerSpawn) {
		for (IObsBawn obs : observers)
			obs.onPlayerSpawnChanged(oldPlayerSpawn, playerSpawn);
	}
}
