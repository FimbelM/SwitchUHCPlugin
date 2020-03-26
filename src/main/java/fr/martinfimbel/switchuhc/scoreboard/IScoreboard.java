package fr.martinfimbel.switchuhc.scoreboard;

import java.util.List;

import fr.martinfimbel.switchuhc.interfaces.IScoreboardMessage;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;
import fr.martinfimbel.switchuhc.task.TimeTask;

public interface IScoreboard extends IObsTimeLine {

	String getTitle();

	List<IScoreboardMessage> getEntries();

	void start();

	void update();

	void pause();

	void relaunched();

	void stop();

	TimeTask getTask();
}
