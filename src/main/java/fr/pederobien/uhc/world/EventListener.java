package fr.pederobien.uhc.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.environment.UHCPlayer;
import fr.pederobien.uhc.observers.IObsListener;

public class EventListener implements Listener {
	private List<IObsListener> observers;

	public EventListener() {
		observers = new ArrayList<IObsListener>();
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		notify(o -> o.onPlayerJoin(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDie(PlayerDeathEvent event) {
		notify(o -> o.onPlayerDie(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerQuit(PlayerQuitEvent event) {
		notify(o -> o.onPlayerQuit(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		notify(o -> o.onPlayerRespawn(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent event) {
		notify(o -> o.onPlayerMove(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		notify(o -> o.onPlayerInteract(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		notify(o -> o.onPlayerInventoryClick(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		notify(o -> o.onCreatureSpawn(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		event.setMessage(UHCPlayer.get(event.getPlayer()).getColor().getInColor(event.getMessage()));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerPortalEvent(PlayerPortalEvent event) {
		notify(o -> o.onPlayerPortalEvent(event));
	}

	public void addObservers(IObsListener obs) {
		observers.add(obs);
	}

	public void removeObservers(IObsListener obs) {
		observers.remove(obs);
	}

	private void notify(Consumer<IObsListener> consumer) {
		for (IObsListener obs : observers)
			consumer.accept(obs);
	}
}
