package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.observers.IObsTimeLine;
import fr.pederobien.uhc.task.TimeTask;

public interface IScoreboard extends IObsTimeLine {
	
	String getTitle();
	
	List<String> getEntries();
	
	void start();

	void update();
	
	void pause();
	
	void relaunched();
	
	void stop();
	
	TimeTask getTask();
}
