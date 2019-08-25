package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.utils.Function;

public interface IScoreboardState extends Function {
	
	List<String> getEntries();
	
	String getTitle();
	
	void start();
	
	void pause(IScoreboardState before);
	
	void relaunched();
	
	void stop();
}
