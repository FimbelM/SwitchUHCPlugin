package fr.pederobien.uhc.world.blocks;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.block.Block;

public interface IBase extends IBawn {

	Map<Block, Material> getChests();
}
