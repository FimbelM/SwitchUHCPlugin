package fr.pederobien.uhc.world.blocks;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import fr.pederobien.uhc.conf.configurations.SerialisableBlock;
import fr.pederobien.uhc.managers.WorldManager;

public class Spawn extends AbstractBawn implements ISpawn {
	public static final Spawn DEFAULT;

	static {
		DEFAULT = new Spawn("DefaultSpawn");
		DEFAULT.setDimensions(5, 1, 5);
		DEFAULT.uniformSpawn(Material.BEDROCK);
	}

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

	private void uniformSpawn(Material material) {
		int maxWidth = getWidth() / 2, maxDepth = getDepth() / 2;
		if (getWidth() % 2 == 1)
			maxWidth += 1;
		if (getDepth() % 2 == 1)
			maxDepth += 1;

		int x, y, z;

		for (x = -getWidth() / 2; x < maxWidth; x++) {
			for (y = 0; y < getHeight(); y++)
				for (z = -getDepth() / 2; z < maxDepth; z++)
					addBlock(new SerialisableBlock(x, y, z, material.createBlockData()));
		}
	}
}
