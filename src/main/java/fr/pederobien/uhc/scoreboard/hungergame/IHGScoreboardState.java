package fr.pederobien.uhc.scoreboard.hungergame;

import java.util.List;

import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IHGScoreboardState extends IObsTimeLine {
	
	List<String> getEntries();
	
	String getTitle();
	
	void start();
		
	void pause(IHGScoreboardState before);
	
	void relaunched();
	
	void stop();
}
