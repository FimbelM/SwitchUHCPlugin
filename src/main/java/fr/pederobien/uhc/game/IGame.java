package fr.pederobien.uhc.game;

import fr.pederobien.uhc.conf.Configuration;
import fr.pederobien.utils.Function;

public interface IGame extends Function {

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
