package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.observer.IObsTimeTask;
import fr.pederobien.utils.Function;

public interface IScoreboardState extends Function, IObsListener, IObsTimeTask {
	
	List<String> getEntries();
	
	String getTitle();
	
	void start();
	
	void pause(IScoreboardState before);
	
	void relaunched();
	
	void stop();
}
