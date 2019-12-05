package fr.pederobien.uhc.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Sound;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.pederobien.uhc.managers.PlayerManager;
import fr.pederobien.uhc.observers.IObsGame;

public abstract class AbstractGame implements IGame {
	private List<IObsGame> observers;

	public AbstractGame() {
		observers = new ArrayList<IObsGame>();
	}

	@Override
	public void onPlayerDie(PlayerDeathEvent event) {
		PlayerManager.getPlayers().forEach(p -> p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 10, 1));
	}

	@Override
	public void addObserver(IObsGame obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(IObsGame obs) {
		observers.remove(obs);
	}

	@Override
	public void start() {
		for (IObsGame obs : observers)
			obs.onStart();
	}

	@Override
	public void stop() {
		for (IObsGame obs : observers)
			obs.onStop();
	}
}
