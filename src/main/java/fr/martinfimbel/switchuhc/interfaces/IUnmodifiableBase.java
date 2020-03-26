package fr.martinfimbel.switchuhc.interfaces;

import java.util.Map;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.martinfimbel.switchuhc.event.InventoryClickResponse;
import fr.martinfimbel.switchuhc.event.PlayerInteractEventResponse;
import fr.martinfimbel.switchuhc.managers.EColor;

public interface IUnmodifiableBase extends IUnmodifiableBawn {

	Map<ISerializableBlock, EColor> getChests();

	PlayerInteractEventResponse isChestRestricted(PlayerInteractEvent event);

	InventoryClickResponse canDropItem(InventoryClickEvent event);

	int getChestsNumber();
}
