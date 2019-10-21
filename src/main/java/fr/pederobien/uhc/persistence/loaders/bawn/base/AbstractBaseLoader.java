package fr.pederobien.uhc.persistence.loaders.bawn.base;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.persistence.loaders.bawn.AbstractBawnLoader;
import fr.pederobien.uhc.world.blocks.Base;

public abstract class AbstractBaseLoader extends AbstractBawnLoader<IBase> {

	public AbstractBaseLoader(String version) {
		super(version, new Base("DefaultBase"));
	}

	protected void show() {
		System.out.println("Name : " + get().getName());
		System.out.println("Center : " + get().getCenter().getX() + " " + get().getCenter().getY() + " "
				+ get().getCenter().getZ());
		System.out.println("chests");
		for (ISerializableBlock b : get().getChests().keySet())
			System.out.println("\t" + b.getX() + " " + b.getY() + " " + b.getZ() + " " + get().getChests().get(b));
		System.out.println("Blocks");
		for (ISerializableBlock b : get().getBlocks())
			System.out.println("\t" + b.getX() + " " + b.getY() + " " + b.getZ() + " " + b.getBlockData());
	}
}
