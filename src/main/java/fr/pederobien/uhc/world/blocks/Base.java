package fr.pederobien.uhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Base extends AbstractBawn implements IBase {
	public static final Base DEFAULT = new Base("DefaultBase");
	private HashMap<Block, ChatColor> chests;

	public Base(String name) {
		super(name);
	}

	@Override
	public Map<Block, ChatColor> getChests() {
		return Collections.unmodifiableMap(chests);
	}
	
	@Override
	public int getChestsNumber() {
		return chests.keySet().size();
	}

	@Override
	public void launch() {
		for (ISerializableBlock block : getBlocks()) {
			getBlockFromCenter(block).setType(block.getMaterial());
			getBlockFromCenter(block).setBlockData(block.getBlockData());
			if (block.getMaterial().equals(Material.CHEST))
				chests.put(getBlockFromCenter(block), getChatColor(block));
		}
	}

	private ChatColor getChatColor(ISerializableBlock chest) {
		switch (getBlockUnderChest(chest).getMaterial()) {
		case LIGHT_BLUE_WOOL:
		case CYAN_WOOL:
		case BLUE_WOOL:
			return ChatColor.DARK_BLUE;

		case LIGHT_GRAY_WOOL:
		case GRAY_WOOL:
			return ChatColor.DARK_GRAY;

		case BLACK_WOOL:
			return ChatColor.BLACK;

		case MAGENTA_WOOL:
		case PINK_WOOL:
		case PURPLE_WOOL:
			return ChatColor.DARK_PURPLE;

		case ORANGE_WOOL:
		case YELLOW_WOOL:
			return ChatColor.GOLD;

		case GREEN_WOOL:
		case LIME_WOOL:
			return ChatColor.DARK_GREEN;

		case RED_WOOL:
			return ChatColor.DARK_RED;

		case WHITE_WOOL:
			return ChatColor.WHITE;

		case BROWN_WOOL:
			return ChatColor.RESET;

		default:
			throw new IllegalArgumentException("Material under chest is not wool");
		}
	}
	
	private ISerializableBlock getBlockUnderChest(ISerializableBlock chest) {
		for (ISerializableBlock block : getBlocks())
			if (block.getX() == chest.getX() && block.getY() == chest.getY() - 1 && block.getZ() == chest.getZ())
				return block;
		return null;
	}
}
