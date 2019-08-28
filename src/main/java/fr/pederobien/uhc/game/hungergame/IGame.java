package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.conf.Configuration;
import fr.pederobien.uhc.game.IGameBase;
import fr.pederobien.uhc.world.EventListener;

public interface IGame extends IGameBase<IGameState>, IGameState {

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
	
	EventListener getEventListener();
}
