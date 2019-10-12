package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.world.blocks.IUnmodifiableBase;

public class BaseManager {
	private List<Block> restrictedChests;
	private HashMap<Player, List<Block>> playerRestrictedChests;

	public BaseManager(List<IUnmodifiableBase> bases) {
		restrictedChests = new ArrayList<Block>();
		playerRestrictedChests = new HashMap<Player, List<Block>>();

		for (IUnmodifiableBase base : bases)
			addBase(base);
	}

	public void addBase(IUnmodifiableBase base) {
		restrictedChests.addAll(base.getChests().keySet());
		base.launch();
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
