package fr.pederobien.uhc.interfaces;

import java.util.List;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();
	
	Double getOneHalfHeart();
	
	Double getOneHeart();
	
	Integer getDiameterAreaOnPlayerRespawn();
	
	Integer getRadiusAreaOnPlayerKill();
	
	List<IUnmodifiableBase> getBases();
}
