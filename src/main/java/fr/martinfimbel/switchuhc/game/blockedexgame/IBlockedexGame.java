package fr.martinfimbel.switchuhc.game.blockedexgame;

import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

public interface IBlockedexGame extends IGame, IObsTimeLine {

	IBlockedexGameState getCurrentState();

	IBlockedexGameState setCurrentState(IBlockedexGameState current);

	IBlockedexGameState getInitiate();

	IBlockedexGameState getStarted();

	IBlockedexGameState getStart();

	IBlockedexGameState getStop();

	IUnmodifiableBlockedexConfiguration getConfiguration();
}
