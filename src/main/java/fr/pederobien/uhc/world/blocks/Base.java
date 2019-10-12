package fr.pederobien.uhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Base extends AbstractBawn implements IBase {
	private HashMap<Block, Material> chests;

	public Base(String name) {
		super(name);
	}

	@Override
	public Map<Block, Material> getChests() {
		return Collections.unmodifiableMap(chests);
	}
}
