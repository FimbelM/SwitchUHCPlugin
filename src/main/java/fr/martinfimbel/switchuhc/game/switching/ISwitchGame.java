package fr.martinfimbel.switchuhc.game.switching;

import fr.martinfimbel.switchuhc.game.IGame;
import fr.martinfimbel.switchuhc.interfaces.IUnmodifiableSwitchConfiguration;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

public interface ISwitchGame extends IGame, IObsTimeLine {

	ISwitchGameState getCurrentState();

	ISwitchGameState setCurrentState(ISwitchGameState current);

	ISwitchGameState getInitiate();

	ISwitchGameState getStart();

	ISwitchGameState getPlayerRevive();

	ISwitchGameState getPlayerDontRevive();

	ISwitchGameState getSwitchGame();

	ISwitchGameState getStop();

	IUnmodifiableSwitchConfiguration getConfiguration();
}
