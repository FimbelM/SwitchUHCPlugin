package fr.pederobien.uhc.world.blocks;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;

public interface IUnmodifiableBase extends IUnmodifiableBawn {

	Map<Block, ChatColor> getChests();
	
	int getChestsNumber();
}
