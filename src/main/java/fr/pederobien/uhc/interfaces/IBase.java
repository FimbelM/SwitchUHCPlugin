package fr.pederobien.uhc.interfaces;

import java.util.HashMap;

import org.bukkit.ChatColor;

public interface IBase extends IBawn, IUnmodifiableBase {
	
	void setChests(HashMap<ISerializableBlock, ChatColor> chests);
}
