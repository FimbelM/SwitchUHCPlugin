package fr.pederobien.uhc.conf.configurations.interfaces;

import java.util.List;

import fr.pederobien.uhc.conf.configurations.IUnmodifiableConfiguration;
import fr.pederobien.uhc.world.blocks.IUnmodifiableBase;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();
	
	Double getOneHalfHeart();
	
	Double getOneHeart();
	
	Integer getDiameterAreaOnPlayerRespawn();
	
	Integer getRadiusAreaOnPlayerKill();
	
	List<IUnmodifiableBase> getBases();
}
