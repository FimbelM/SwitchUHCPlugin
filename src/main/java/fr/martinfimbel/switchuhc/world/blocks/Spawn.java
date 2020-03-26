package fr.martinfimbel.switchuhc.world.blocks;

import org.bukkit.block.Block;

import fr.martinfimbel.switchuhc.interfaces.ISerializableBlock;
import fr.martinfimbel.switchuhc.interfaces.ISpawn;
import fr.martinfimbel.switchuhc.managers.WorldManager;
import fr.martinfimbel.switchuhc.observers.IObsBawn;

public class Spawn extends AbstractBawn implements ISpawn {
	private static final Block DEFAULT_PLAYER_SPAWN = WorldManager.getHighestBlockYAt(0, 0);

	private ISerializableBlock playerSpawn;

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
		return playerSpawn == null ? DEFAULT_PLAYER_SPAWN : getBlockFromCenter(playerSpawn);
	}

	@Override
	public ISerializableBlock getPlayerSpawnRelativeToCenter() {
		return getRelativeBlockFromTheWorld(getPlayerSpawn());
	}

	@Override
	public void setPlayerSpawn(Block playerSpawn) {
		Block oldPlayerSpawn = getPlayerSpawn();
		this.playerSpawn = getRelativeBlockFromTheWorld(playerSpawn);
		onPlayerSpawnChanged(oldPlayerSpawn);
	}

	@Override
	public void setPlayerSpawn(String x, String y, String z) {
		setPlayerSpawn(WorldManager.getBlockAt(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z)));
	}

	@Override
	public void setPlayerSpawnRelativeToCenter(String x, String y, String z) {
		setPlayerSpawn(getBlockFromCenter(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z)));
	}

	@Override
	public void reset() {
		super.reset();
		playerSpawn = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Players' spawn : " + showBlock(getPlayerSpawn()) + "");
		return builder.toString();
	}

	private void onPlayerSpawnChanged(Block oldPlayerSpawn) {
		for (IObsBawn obs : observers)
			obs.onPlayerSpawnChanged(oldPlayerSpawn, getPlayerSpawn());
	}
}
