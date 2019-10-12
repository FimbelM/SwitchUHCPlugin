package fr.pederobien.uhc.conf.configurations.interfaces;

import java.util.List;

import fr.pederobien.uhc.conf.configurations.IConfiguration;
import fr.pederobien.uhc.world.blocks.IBase;

public interface IBlockedexConfiguration extends IConfiguration, IUnmodifiableBlockedexConfiguration {

	void setRadiusAreaOnPlayerDie(int radiusAreaOnPlayerDie);
	
	void setStepOnMaxHealth(double stepHealth);
	
	void setDiameterAreaOnPlayerRespawn(int diameterArea);
	
	void setRadiusAreaOnPlayerKill(int radiusAreaOnPlayerKill);
	
	void setBases(List<IBase> bases);
}
