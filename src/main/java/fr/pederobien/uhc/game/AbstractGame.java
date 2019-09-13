package fr.pederobien.uhc.game;

import java.util.ArrayList;
import java.util.List;

import fr.pederobien.uhc.observer.IObsGame;

public abstract class AbstractGame implements IGame {
	private List<IObsGame> observers;
	
	public AbstractGame() {
		observers = new ArrayList<IObsGame>();
	}
	
	@Override
	public void AddObserver(IObsGame obs) {
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
