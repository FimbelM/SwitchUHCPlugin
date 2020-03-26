package fr.martinfimbel.switchuhc.game.hungergame;

import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableHungerGameConfiguration;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

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
