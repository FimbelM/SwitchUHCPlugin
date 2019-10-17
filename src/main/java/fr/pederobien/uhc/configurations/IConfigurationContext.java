package fr.pederobien.uhc.configurations;

import fr.pederobien.uhc.game.IGame;

public interface IConfigurationContext extends IConfiguration, IGame {
	
	void setCurrentConfiguration(IConfiguration configuration);
	
	IConfiguration getCurrentConfiguration();
}
