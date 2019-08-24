package fr.pederobien.uhc.scoreboard;

import java.util.List;

import fr.pederobien.uhc.game.IGameState;

public interface IScoreboardState extends IGameState {
	
	List<String> getEntries();
	
	String getTitle();
}
