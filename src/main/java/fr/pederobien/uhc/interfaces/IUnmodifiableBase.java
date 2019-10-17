package fr.pederobien.uhc.interfaces;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface IUnmodifiableBase extends IUnmodifiableBawn {
	
	Map<ISerializableBlock, ChatColor> getChests();

	boolean isChestRestricted(Block block, Player player);
	
	int getChestsNumber();
}
