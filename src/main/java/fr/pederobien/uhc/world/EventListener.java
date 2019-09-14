package fr.pederobien.uhc.world;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.observer.IObsListener;

public class EventListener implements Listener {
	private List<IObsListener> observers;

	public EventListener() {
		observers = new ArrayList<IObsListener>();
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerJoin(event);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDie(PlayerDeathEvent event) {
		System.out.println("Listener : on player die");
		for (IObsListener obs : observers)
			obs.onPlayerDie(event);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerQuit(PlayerQuitEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerQuit(event);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerRespawn(event);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerMove(event);
	}

	public void addObservers(IObsListener obs) {
		observers.add(obs);
	}

	public void removeObservers(IObsListener obs) {
		observers.remove(obs);
	}
}
