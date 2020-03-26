package fr.martinfimbel.switchuhc.scoreboard;

import java.util.List;

import fr.martinfimbel.switchuhc.interfaces.IScoreboardMessage;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

public interface IScoreboardState extends IObsTimeLine {

	List<IScoreboardMessage> getEntries();

	String getTitle();

	void start();

	void relaunched();

	void stop();
}
