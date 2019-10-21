package fr.pederobien.uhc.world.blocks;

import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.interfaces.ISpawn;
import fr.pederobien.uhc.managers.WorldManager;

public class Spawn extends AbstractBawn implements ISpawn {
	public static final ISpawn DEFAULT = new Spawn("DefaultSpawn");

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
		WorldManager.setSpawn(DEFAULT);
	}
}
