package fr.martinfimbel.switchuhc.world.blocks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.event.EventFactory;
import fr.martinfimbel.switchuhc.event.InventoryClickResponse;
import fr.martinfimbel.switchuhc.event.PlayerInteractEventResponse;
import fr.martinfimbel.switchuhc.exceptions.BaseExtractionException;
import fr.martinfimbel.switchuhc.game.blockedexgame.object.BlocksToFind;
import fr.martinfimbel.switchuhc.interfaces.IBase;
import fr.martinfimbel.switchuhc.interfaces.ISerializableBlock;
import fr.martinfimbel.switchuhc.managers.EColor;
import fr.martinfimbel.switchuhc.managers.TeamsManager;

public class Base extends AbstractBawn implements IBase {
	private Map<ISerializableBlock, EColor> chests;

	public Base(String name) {
		super(name);
		chests = new HashMap<ISerializableBlock, EColor>();
	}

	@Override
	public Map<ISerializableBlock, EColor> getChests() {
		return Collections.unmodifiableMap(chests);
	}

	@Override
	public PlayerInteractEventResponse isChestRestricted(PlayerInteractEvent event) {
		boolean restricted = false, founded = false;
		EColor color = TeamsManager.getTeam(event.getPlayer()).getColor();
		EColor colorAuthorized = color;
		for (ISerializableBlock b : chests.keySet())
			if (getBlockFromCenter(b).equals(event.getClickedBlock())) {
				founded = true;
				colorAuthorized = chests.get(b);
				restricted = !colorAuthorized.equals(color);
			}
		return EventFactory.createPlayerInteractEventResponse(event, founded, restricted, colorAuthorized);
	}

	@Override
	public InventoryClickResponse canDropItem(InventoryClickEvent event) {
		boolean founded = false, canDropItem = true, blockForbidden = false, blockAlreadyDropped = false, cannotGetItemBack = false;
		for (ISerializableBlock b : chests.keySet()) {
			Block block = event.getClickedInventory().getLocation().getBlock();
			if (!getBlockFromCenter(b).equals(block))
				continue;

			founded = true;
			if (event.getCursor().getType().equals(Material.AIR)) {
				canDropItem = false;
				cannotGetItemBack = true;
			} else if (!BlocksToFind.contains(event.getCursor().getType())) {
				canDropItem = false;
				blockForbidden = true;
			} else {
				Chest chest = (Chest) block.getState();
				if (chest.getBlockInventory().contains(event.getCursor())) {
					canDropItem = false;
					blockAlreadyDropped = true;
				}
			}
		}
		return EventFactory.createInventoryClickResponse(event, founded, canDropItem, blockForbidden, blockAlreadyDropped, cannotGetItemBack);
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
			chests.put(extractedBlock, EColor.getByColor(getChatColor(extractedBlock)));
	}

	@Override
	public void setChests(Map<ISerializableBlock, EColor> chests) {
		this.chests = chests;
	}

	@Override
	public void reset() {
		super.reset();
		chests.clear();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("Supported colors :\n" + showColors());
		return builder.toString();
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

	private String showColors() {
		String colors = "";
		for (EColor color : chests.values())
			colors += color.getColoredColorName() + "\n";
		return colors;
	}
}
