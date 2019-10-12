package fr.pederobien.uhc.world.blocks;

import org.bukkit.Material;
import org.bukkit.util.Vector;

import fr.pederobien.uhc.conf.configurations.SerialisableBlock;
import fr.pederobien.uhc.managers.WorldManager;

public class Spawn extends AbstractBawn implements ISpawn {
	public static final Spawn DEFAULT;

	static {
		DEFAULT = new Spawn("DefaultSpawn");
		DEFAULT.createDefault();
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

	@Override
	protected void createDefault() {
		setDimensions(5, 1, 5);
		int maxWidth = getWidth() / 2, maxDepth = getDepth() / 2;
		if (getWidth() % 2 == 1)
			maxWidth += 1;
		if (getDepth() % 2 == 1)
			maxDepth += 1;

		for (int x = -getWidth() / 2; x < maxWidth; x++) {
			for (int y = 0; y < getHeight(); y++)
				for (int z = -getDepth() / 2; z < maxDepth; z++)
					addBlock(new SerialisableBlock(x, y, z, Material.BEDROCK.createBlockData()));
		}
	}
}
