package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.interfaces.IBawn;
import fr.pederobien.uhc.world.blocks.Spawn;

public interface ISpawn extends IBawn {
	public static final ISpawn DEFAULT = new Spawn("DefaultSpawn");

}
