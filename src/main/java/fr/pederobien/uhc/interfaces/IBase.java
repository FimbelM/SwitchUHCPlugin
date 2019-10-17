package fr.pederobien.uhc.interfaces;

import java.util.HashMap;

import org.bukkit.ChatColor;

import fr.pederobien.uhc.world.blocks.Base;

public interface IBase extends IBawn, IUnmodifiableBase {
	public static final IBase DEFAULT = new Base("DefaultBase");
	
	void setChests(HashMap<ISerializableBlock, ChatColor> chests);
}
