package fr.pederobien.uhc.conf.configurations.interfaces;

import fr.pederobien.uhc.conf.configurations.IConfiguration;

public interface IBlockedexConfiguration extends IConfiguration, IUnmodifiableBlockedexConfiguration {

	void setRadiusAreaOnPlayerDie(int radiusArea);
	
	void setStepOnMaxHealth(double stepHealth);
	
	void setDiameterAreaOnPlayerRespawn(int diameterArea);
}
