package fr.pederobien.uhc.conf.configurations.interfaces;

import fr.pederobien.uhc.conf.configurations.IUnmodifiableConfiguration;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();
	
	Double getStepOnMaxHealth();
	
	Integer getDiameterAreaOnPlayerRespawn();
}
