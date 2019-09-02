package fr.pederobien.uhc.game;

import fr.pederobien.uhc.observer.IObsListener;

public interface IGame extends IObsListener {
	
	void initiate();

	void start();
	
	void stop();
	
	void pause();
	
	void relaunch();
}
