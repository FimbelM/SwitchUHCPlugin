package fr.pederobien.uhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.managers.TeamsManager;

public class Base extends AbstractBawn implements IBase {
	public static final Base DEFAULT = new Base("DefaultBase");

	private HashMap<ISerializableBlock, ChatColor> chests;

	public Base(String name) {
		super(name);
		chests = new HashMap<ISerializableBlock, ChatColor>();
	}

	@Override
	public Map<ISerializableBlock, ChatColor> getChests() {
		return Collections.unmodifiableMap(chests);
	}

	@Override
	public boolean isChestRestricted(Block block, Player player) {
		for (ISerializableBlock b : chests.keySet())
			if (getBlockFromCenter(b).equals(block))
				return chests.get(b) == TeamsManager.getColor(player);
		return true;
	}

	@Override
	public int getChestsNumber() {
		return chests.size();
	}

	@Override
	public void extract() {
		chests.clear();
		super.extract();
	}

	@Override
	protected void onExtraction(ISerializableBlock extractedBlock) {
		if (extractedBlock.getMaterial().equals(Material.CHEST))
			chests.put(extractedBlock, getChatColor(extractedBlock));
	}

	@Override
	public void setChests(HashMap<ISerializableBlock, ChatColor> chests) {
		this.chests = chests;
	}

	private ChatColor getChatColor(ISerializableBlock chest) {
		switch (getBlockUnderChest(chest).getMaterial()) {
		case LIGHT_BLUE_WOOL:
			return ChatColor.AQUA;
		case CYAN_WOOL:
			return ChatColor.BLUE;
		case BLUE_WOOL:
			return ChatColor.DARK_BLUE;

		case LIGHT_GRAY_WOOL:
			return ChatColor.GRAY;
		case GRAY_WOOL:
			return ChatColor.DARK_GRAY;

		case BLACK_WOOL:
			return ChatColor.BLACK;

		case PINK_WOOL:
			return ChatColor.LIGHT_PURPLE;
		case PURPLE_WOOL:
			return ChatColor.DARK_PURPLE;

		case ORANGE_WOOL:
			return ChatColor.GOLD;
		case YELLOW_WOOL:
			return ChatColor.YELLOW;

		case GREEN_WOOL:
			return ChatColor.GREEN;
		case LIME_WOOL:
			return ChatColor.DARK_GREEN;

		case RED_WOOL:
			return ChatColor.DARK_RED;

		case WHITE_WOOL:
			return ChatColor.WHITE;

		case MAGENTA_WOOL:
			throw new IllegalArgumentException("Usage of magenta wool is forbidden, please use pink or purple woord");

		case BROWN_WOOL:
			throw new IllegalArgumentException("Brown wool as no equivalent in team's color");

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
