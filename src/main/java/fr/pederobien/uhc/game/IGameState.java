package fr.pederobien.uhc.game;

import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IGameState extends IObsListener, IObsTimeLine {

	void initiate();

	void start();

	void pause();

	void relaunch();

	void stop();
}
