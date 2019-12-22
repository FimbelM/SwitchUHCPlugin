package fr.pederobien.uhc.interfaces;

import java.util.Map;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.pederobien.uhc.event.InventoryClickResponse;
import fr.pederobien.uhc.event.PlayerInteractEventResponse;
import fr.pederobien.uhc.managers.EColor;

public interface IUnmodifiableBase extends IUnmodifiableBawn {

	Map<ISerializableBlock, EColor> getChests();

	PlayerInteractEventResponse isChestRestricted(PlayerInteractEvent event);

	InventoryClickResponse canDropItem(InventoryClickEvent event);

	int getChestsNumber();
}
