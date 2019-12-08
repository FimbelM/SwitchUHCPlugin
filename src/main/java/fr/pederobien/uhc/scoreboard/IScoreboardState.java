package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.interfaces.IScoreboardMessage;
import fr.pederobien.uhc.observers.IObsTimeLine;

public interface IScoreboardState extends IObsTimeLine {

	List<IScoreboardMessage> getEntries();

	String getTitle();

	void start();

	void relaunched();

	void stop();
}
