package fr.pederobien.uhc.scoreboard;

import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IScoreboard extends IObsTimeLine {
	
	String getTitle();
	
	void start();

	void update();
	
	void pause();
	
	void relaunched();
	
	void stop();
}
