package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.interfaces.IScoreboardMessage;
import fr.pederobien.uhc.observers.IObsTimeLine;
import fr.pederobien.uhc.task.TimeTask;

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
