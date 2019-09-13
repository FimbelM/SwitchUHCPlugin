package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IHungerGameState extends IObsListener, IObsTimeLine {

	void initiate();

	void start();

	void pause(IHungerGameState before);

	void relaunch();

	void stop();
}
