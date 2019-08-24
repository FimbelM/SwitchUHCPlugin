package fr.pederobien.uhc.game;

import fr.pederobien.uhc.conf.Configuration;

public interface IGame extends IGameState {

	IGameState getCurrentState();

	IGameState setCurrentState(IGameState current);

	IGameState getInitiate();

	IGameState getStart();

	IGameState getPlayerRevive();

	IGameState getPlayerDontRevive();

	IGameState getHungerGame();

	IGameState getPause();

	IGameState getStop();

	Configuration getConfiguration();
}
