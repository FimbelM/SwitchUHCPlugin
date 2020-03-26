package fr.martinfimbel.switchuhc.event;

import org.bukkit.command.CommandSender;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.martinfimbel.switchuhc.interfaces.IMessageCode;
import fr.martinfimbel.switchuhc.managers.EColor;

public class EventFactory {

	public static MessageCodeEvent createMessageCodeEvent(IMessageCode code, String... args) {
		return new MessageCodeEvent(code, args);
	}

	public static MessageEvent createMessageEvent(CommandSender sender, MessageCodeEvent event) {
		return new MessageEvent(sender, event);
	}

	public static MessageEvent createMessageEvent(CommandSender sender, IMessageCode code, String... args) {
		return new MessageEvent(sender, createMessageCodeEvent(code, args));
	}

	public static PlayerInteractEventResponse createPlayerInteractEventResponse(PlayerInteractEvent event, boolean founded, boolean restricted,
			EColor colorAllowed) {
		return new PlayerInteractEventResponse(event, founded, restricted, colorAllowed);
	}

	public static InventoryClickResponse createInventoryClickResponse(InventoryClickEvent event, boolean founded, boolean canDropItem,
			boolean blockForbidden, boolean blockAlreadyDropped, boolean cannotGetItemBack) {
		return new InventoryClickResponse(event, founded, canDropItem, blockForbidden, blockAlreadyDropped, cannotGetItemBack);
	}
}
