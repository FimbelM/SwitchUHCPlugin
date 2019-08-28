package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.conf.Configuration;
import fr.pederobien.uhc.world.EventListener;

public interface IGame extends IHungerGameState {

	IHungerGameState getCurrentState();

	IHungerGameState setCurrentState(IHungerGameState current);

	IHungerGameState getInitiate();

	IHungerGameState getStart();

	IHungerGameState getPlayerRevive();

	IHungerGameState getPlayerDontRevive();

	IHungerGameState getHungerGame();

	IHungerGameState getPause();

	IHungerGameState getStop();

	Configuration getConfiguration();
	
	EventListener getEventListener();
}
