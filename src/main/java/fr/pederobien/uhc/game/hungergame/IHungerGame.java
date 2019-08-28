package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.world.EventListener;

public interface IHungerGame extends IHungerGameState {

	IHungerGameState getCurrentState();

	IHungerGameState setCurrentState(IHungerGameState current);

	IHungerGameState getInitiate();

	IHungerGameState getStart();

	IHungerGameState getPlayerRevive();

	IHungerGameState getPlayerDontRevive();

	IHungerGameState getHungerGame();

	IHungerGameState getPause();

	IHungerGameState getStop();

	HungerGameConfiguration getConfiguration();
	
	EventListener getEventListener();
}
