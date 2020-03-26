package fr.martinfimbel.switchuhc.game;

import fr.martinfimbel.switchuhc.dictionary.dictionaries.MessageCode;
import fr.martinfimbel.switchuhc.observers.IObsGame;
import fr.martinfimbel.switchuhc.observers.IObsListener;

public interface IGame extends IObsListener {

	boolean initiate();

	void start();

	void stop();

	void pause();

	void relaunch();

	void addObserver(IObsGame obs);

	void removeObserver(IObsGame obs);

	MessageCode getMessage();
}
