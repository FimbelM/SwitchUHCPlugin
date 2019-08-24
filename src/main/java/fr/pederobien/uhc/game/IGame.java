package fr.pederobien.uhc.game;

public interface IGame {
	
	IGameState getCurrentState();
	
	void setCurrentState(IGameState current);
	
	IGameState getInitiate();
	
	IGameState getStart();
	
	IGameState getPlayerRevive();
	
	IGameState getPlayerDontRevive();
	
	IGameState getHungerGame();
	
	IGameState getPause();
	
	IGameState getRelaunched();
	
	IGameState getStop();
}
