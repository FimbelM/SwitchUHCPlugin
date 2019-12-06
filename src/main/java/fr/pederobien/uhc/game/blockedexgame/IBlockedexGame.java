package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.interfaces.IUnmodifiableBlockedexConfiguration;
import fr.pederobien.uhc.observers.IObsTimeLine;

public interface IBlockedexGame extends IGame, IObsTimeLine {

	IBlockedexGameState getCurrentState();

	IBlockedexGameState setCurrentState(IBlockedexGameState current);

	IBlockedexGameState getInitiate();

	IBlockedexGameState getStarted();

	IBlockedexGameState getStart();

	IBlockedexGameState getStop();

	IUnmodifiableBlockedexConfiguration getConfiguration();
}
