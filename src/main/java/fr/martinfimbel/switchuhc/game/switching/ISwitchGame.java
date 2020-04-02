package fr.martinfimbel.switchuhc.game.switching;

import java.time.LocalTime;

import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;
import fr.martinfimbel.switchuhc.observers.IObsLoopTimeLine;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

public interface ISwitchGame extends IGame, IObsTimeLine, IObsLoopTimeLine {

	ISwitchGameState getCurrentState();

	ISwitchGameState setCurrentState(ISwitchGameState current);

	ISwitchGameState getInitiate();

	ISwitchGameState getStart();

	ISwitchGameState getPlayerRevive();

	ISwitchGameState getPlayerDontRevive();

	ISwitchGameState getSwitchGame();

	ISwitchGameState getStop();
	
	LocalTime getNextSwitchTime();

	LocalTime getDecreasingSwitchTime();
	
	IUnmodifiableSwitchConfiguration getConfiguration();

}
