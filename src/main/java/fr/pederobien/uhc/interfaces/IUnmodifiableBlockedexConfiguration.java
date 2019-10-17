package fr.pederobien.uhc.interfaces;

import java.util.List;

import fr.pederobien.uhc.configurations.IUnmodifiableConfiguration;
import fr.pederobien.uhc.world.blocks.IUnmodifiableBase;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();
	
	Double getOneHalfHeart();
	
	Double getOneHeart();
	
	Integer getDiameterAreaOnPlayerRespawn();
	
	Integer getRadiusAreaOnPlayerKill();
	
	List<IUnmodifiableBase> getBases();
}
