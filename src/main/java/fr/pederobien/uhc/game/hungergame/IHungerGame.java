package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.conf.configurations.HungerGameConfiguration;
import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.observer.IObsListener;
import fr.pederobien.uhc.world.EventListener;
import fr.pederobien.utils.Function;

public interface IHungerGame extends IGame, IObsListener, Function {

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
