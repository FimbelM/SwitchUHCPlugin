package fr.martinfimbel.switchuhc.interfaces;

import fr.martinfimbel.switchuhc.game.IGame;

public interface IConfigurationContext extends IConfiguration, IGame {

	void setCurrentConfiguration(IConfiguration configuration);

	IConfiguration getCurrentConfiguration();
}
