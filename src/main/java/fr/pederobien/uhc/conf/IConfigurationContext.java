package fr.pederobien.uhc.conf;

import fr.pederobien.uhc.conf.configurations.IConfiguration;
import fr.pederobien.uhc.game.IGame;

public interface IConfigurationContext extends IConfiguration, IGame {
	
	void setCurrentConfiguration(IConfiguration configuration);
	
	IConfiguration getCurrentConfiguration();
}
