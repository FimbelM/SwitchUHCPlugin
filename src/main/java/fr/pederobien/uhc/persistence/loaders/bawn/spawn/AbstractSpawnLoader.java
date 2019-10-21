package fr.pederobien.uhc.persistence.loaders.bawn.spawn;

import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.interfaces.ISpawn;
import fr.pederobien.uhc.persistence.loaders.bawn.AbstractBawnLoader;
import fr.pederobien.uhc.world.blocks.Spawn;

public abstract class AbstractSpawnLoader extends AbstractBawnLoader<ISpawn> {
	
	public AbstractSpawnLoader(String version) {
		super(version, new Spawn("DefaultSpawn"));
	}
	
	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Center : " + get().getCenter().getX() + " " + get().getCenter().getY() + " "
				+ get().getCenter().getZ());
		System.out.println("Blocks");
		for (ISerializableBlock b : get().getBlocks())
			System.out.println(
					"\t" + b.getX() + " " + b.getY() + " " + b.getZ() + " " + b.getBlockData());
	}
}
