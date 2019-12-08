package fr.pederobien.uhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;
import fr.pederobien.uhc.event.EventFactory;
import fr.pederobien.uhc.event.PlayerInteractEventResponse;
import fr.pederobien.uhc.exceptions.BaseExtractionException;
import fr.pederobien.uhc.interfaces.IBase;
import fr.pederobien.uhc.interfaces.ISerializableBlock;
import fr.pederobien.uhc.managers.ETeam;

public class Base extends AbstractBawn implements IBase {
	private HashMap<ISerializableBlock, ETeam> chests;

	public Base(String name) {
		super(name);
		chests = new HashMap<ISerializableBlock, ETeam>();
	}

	@Override
	public Map<ISerializableBlock, ETeam> getChests() {
		return Collections.unmodifiableMap(chests);
	}

	@Override
	public PlayerInteractEventResponse isChestRestricted(Block block, ETeam color) {
		boolean restricted = false;
		ETeam colorAuthorized = color;
		for (ISerializableBlock b : chests.keySet())
			if (getBlockFromCenter(b).equals(block)) {
				colorAuthorized = chests.get(b);
				restricted = colorAuthorized.equals(color);
			}
		return EventFactory.createPlayerInteractEventResponse(restricted, colorAuthorized);
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
			chests.put(extractedBlock, ETeam.getByColor(getChatColor(extractedBlock)));
	}

	@Override
	public void setChests(HashMap<ISerializableBlock, ETeam> chests) {
		this.chests = chests;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
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
			throw new BaseExtractionException(MessageCode.EXTRACT_BASE_MAGENTA_WOOL_IS_FORBIDDEN);

		case BROWN_WOOL:
			throw new BaseExtractionException(MessageCode.EXTRACT_BASE_BROWN_WOOL_HAS_NO_EQUIVALENT);

		default:
			throw new BaseExtractionException(MessageCode.EXTRACT_BASE_MATERIAL_UNDER_CHEST_IS_NOT_WOOL);
		}
	}

	private ISerializableBlock getBlockUnderChest(ISerializableBlock chest) {
		for (ISerializableBlock block : getBlocks())
			if (block.getX() == chest.getX() && block.getY() == chest.getY() - 1 && block.getZ() == chest.getZ())
				return block;
		return null;
	}
}
