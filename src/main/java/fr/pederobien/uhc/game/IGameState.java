package fr.pederobien.uhc.game;

import fr.pederobien.uhc.observers.IObsListener;
import fr.pederobien.uhc.observers.IObsTimeLine;

public interface IGameState extends IObsListener, IObsTimeLine {

	boolean initiate();

	void start();

	void pause();

	void relaunch();

	void stop();
	
	String getMessage();
}
