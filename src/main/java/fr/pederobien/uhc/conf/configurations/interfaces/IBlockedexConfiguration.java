package fr.pederobien.uhc.conf.configurations.interfaces;

import fr.pederobien.uhc.conf.configurations.IConfiguration;

public interface IBlockedexConfiguration extends IConfiguration, IUnmodifiableBlockedexConfiguration {

	void setRadiusAreaOnPlayerDie(int radiusAreaOnPlayerDie);
	
	void setStepOnMaxHealth(double stepHealth);
	
	void setDiameterAreaOnPlayerRespawn(int diameterArea);
	
	void setRadiusAreaOnPlayerKill(int radiusAreaOnPlayerKill);
}
