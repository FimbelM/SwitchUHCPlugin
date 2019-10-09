package fr.pederobien.uhc.game.hungergame;

import fr.pederobien.uhc.conf.configurations.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IHungerGame extends IGame, IObsTimeLine {

	IHungerGameState getCurrentState();

	IHungerGameState setCurrentState(IHungerGameState current);

	IHungerGameState getInitiate();

	IHungerGameState getStart();

	IHungerGameState getPlayerRevive();

	IHungerGameState getPlayerDontRevive();

	IHungerGameState getHungerGame();

	IHungerGameState getStop();

	IUnmodifiableHungerGameConfiguration getConfiguration();
	
}
