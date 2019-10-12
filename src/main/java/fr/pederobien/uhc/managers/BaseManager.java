package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.world.blocks.IBase;

public class BaseManager {
	private List<Block> restrictedChests;
	private HashMap<Player, List<Block>> playerRestrictedChests;

	public BaseManager() {
		restrictedChests = new ArrayList<Block>();
		playerRestrictedChests = new HashMap<Player, List<Block>>();
	}

	public void addBase(IBase base) {
		restrictedChests.addAll(base.getChests().keySet());
	}

	public boolean isChestAccessible(Player player, Block block) {
		if (!block.getType().equals(Material.CHEST))
			return true;

		if (!restrictedChests.contains(block))
			return true;
		else
			return playerRestrictedChests.get(player).contains(block);
	}
}
