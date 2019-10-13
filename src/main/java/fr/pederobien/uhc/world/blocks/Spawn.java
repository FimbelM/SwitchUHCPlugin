package fr.pederobien.uhc.world.blocks;

import org.bukkit.util.Vector;

import fr.pederobien.uhc.managers.WorldManager;

public class Spawn extends AbstractBawn implements ISpawn {

	public Spawn(String name) {
		super(name);
	}

	@Override
	public void launch() {
		super.launch();
		WorldManager.setSpawnOnJoin(getCenter().getLocation().clone().add(new Vector(0, 1, 0)));
	}

	@Override
	public void remove() {
		super.remove();
		WorldManager.setSpawnOnJoin(WorldManager.getHighestBlockYAt(0, 0).getLocation());
	}
}
