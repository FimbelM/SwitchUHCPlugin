package fr.pederobien.uhc.world;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.uhc.observer.IObsListener;

public class EventListener implements IListener {
	private List<IObsListener> observers;

	public EventListener() {
		observers = new ArrayList<IObsListener>();
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerJoin(event);
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerDie(event);
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerQuit(event);
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerRespawn(event);
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		for (IObsListener obs : observers)
			obs.onPlayerMove(event);
	}

	@Override
	public void addObservers(IObsListener obs) {
		observers.add(obs);
	}

	@Override
	public void removeObservers(IObsListener obs) {
		observers.remove(obs);
	}
}
