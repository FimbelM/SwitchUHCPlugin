package fr.pederobien.uhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public class Base extends AbstractBawn implements IBase {
	public static final Base DEFAULT;
	private HashMap<Block, ChatColor> chests;
	
	static {
		DEFAULT = new Base("DefaultBase");
		DEFAULT.createDefault();
	}

	public Base(String name) {
		super(name);
	}

	@Override
	public Map<Block, ChatColor> getChests() {
		return Collections.unmodifiableMap(chests);
	}

	@Override
	public void launch() {
		for (Coordinate coord : getBlocks().keySet()) {
			getBlockFromCenter(coord).setType(getBlocks().get(coord).getMaterial());
			getBlockFromCenter(coord).setBlockData(getBlocks().get(coord));
			if (getBlocks().get(coord).getMaterial().equals(Material.CHEST))
				chests.put(getBlockFromCenter(coord), getChatColor(coord));
		}
	}

	private ChatColor getChatColor(Coordinate chest) {
		BlockData data = getBlocks().get(new Coordinate(chest.getX(), chest.getY() - 1, chest.getZ()));
		switch (data.getMaterial()) {
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
	
	@Override
	protected void createDefault() {
		setDimensions(5, 5, 5);
	}
}
