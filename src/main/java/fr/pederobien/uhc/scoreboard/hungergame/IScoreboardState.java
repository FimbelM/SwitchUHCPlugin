package fr.pederobien.uhc.scoreboard.hungergame;

import java.util.List;

import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IScoreboardState extends IObsTimeLine {
	
	List<String> getEntries();
	
	String getTitle();
	
	void start();
		
	void pause(IScoreboardState before);
	
	void relaunched();
	
	void stop();
}
