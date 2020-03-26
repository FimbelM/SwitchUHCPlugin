package fr.martinfimbel.switchuhc.game;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.observers.IObsListener;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

public interface IGameState extends IObsListener, IObsTimeLine {

	boolean initiate();

	void start();

	void pause();

	void relaunch();

	void stop();

	MessageCode getMessage();
}
