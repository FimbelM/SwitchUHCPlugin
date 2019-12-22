package fr.pederobien.uhc.game.blockedexgame.object;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class BlocksToFind {
	private static List<Material> blocks;

	public static void initialize() {
		blocks = new ArrayList<Material>();

		blocks.add(Material.BLUE_WOOL);
		blocks.add(Material.CYAN_WOOL);
		blocks.add(Material.MAGENTA_WOOL);
		blocks.add(Material.RED_WOOL);
	}

	public static boolean contains(Material material) {
		return blocks.contains(material);
	}
}
