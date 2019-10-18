package fr.pederobien.uhc.interfaces;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();
	
	Double getOneHalfHeart();
	
	Double getOneHeart();
	
	Integer getDiameterAreaOnPlayerRespawn();
	
	Integer getRadiusAreaOnPlayerKill();
	
	String getNorthBase();
	
	String getSouthBase();
	
	String getWestBase();
	
	String getEastBase();
	
	Integer getBaseFromSpawnDistance();
}
