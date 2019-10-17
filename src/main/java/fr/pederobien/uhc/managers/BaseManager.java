package fr.pederobien.uhc.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.world.blocks.IUnmodifiableBase;

public class BaseManager {
	private List<IUnmodifiableBase> bases;

	public BaseManager(List<IUnmodifiableBase> bases) {
		bases = new ArrayList<IUnmodifiableBase>();

		for (IUnmodifiableBase base : bases)
			addBase(base);
	}

	public void addBase(IUnmodifiableBase base) {
		bases.add(base);
		base.launch();
	}

	public boolean isChestAccessible(Player player, Block block) {
		if (!block.getType().equals(Material.CHEST))
			return true;
		
		boolean accessible = true;
		for (IUnmodifiableBase base : bases)
			accessible &= !base.isChestRestricted(block, player);
		return accessible;
	}
}
