package fr.pederobien.uhc.world.blocks;

import java.util.HashMap;

import org.bukkit.ChatColor;

public interface IBase extends IBawn, IUnmodifiableBase {
	public static final IBase DEFAULT = new Base("DefaultBase");
	
	void setChests(HashMap<ISerializableBlock, ChatColor> chests);
}
