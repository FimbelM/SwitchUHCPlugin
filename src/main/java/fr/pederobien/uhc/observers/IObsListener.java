package fr.pederobien.uhc.observers;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public interface IObsListener {

	void onPlayerJoin(PlayerJoinEvent event);

	void onPlayerDie(PlayerDeathEvent event);

	void onPlayerQuit(PlayerQuitEvent event);

	void onPlayerRespawn(PlayerRespawnEvent event);

	void onPlayerMove(PlayerMoveEvent event);

	void onPlayerInteract(PlayerInteractEvent event);

	void onPlayerInventoryMoveItem(InventoryMoveItemEvent event);

	void onCreatureSpawn(CreatureSpawnEvent event);

	void onPlayerPortalEvent(PlayerPortalEvent event);
}
