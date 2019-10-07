package fr.pederobien.uhc.game.blockedexgame;

import fr.pederobien.uhc.conf.configurations.BlockedexConfiguration;
import fr.pederobien.uhc.game.IGame;
import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IBlockedexGame extends IGame, IObsTimeLine {
	
	IBlockedexGameState getCurrentState();
	
	IBlockedexGameState setCurrentState(IBlockedexGameState current);
	
	IBlockedexGameState getInitiate();
	
	IBlockedexGameState getStarted();
	
	IBlockedexGameState getStart();
	
	IBlockedexGameState getStop();
	
	BlockedexConfiguration getConfiguration();
}
