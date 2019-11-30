package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.observers.IObsTimeLine;

public interface IScoreboardState extends IObsTimeLine {

	List<String> getEntries();

	String getTitle();

	void start();

	void relaunched();

	void stop();
}
