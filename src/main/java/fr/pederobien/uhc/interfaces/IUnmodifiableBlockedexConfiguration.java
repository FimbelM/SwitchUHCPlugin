package fr.pederobien.uhc.interfaces;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();
	
	Double getStepOnMaxHealth();
	
	Double getDoubleStepOnMaxHealth();
	
	Integer getDiameterAreaOnPlayerRespawn();
	
	Integer getRadiusAreaOnPlayerKill();
	
	IUnmodifiableBase getNorthBase();
	
	IUnmodifiableBase getSouthBase();
	
	IUnmodifiableBase getWestBase();
	
	IUnmodifiableBase getEastBase();
	
	Integer getBaseFromSpawnDistance();
}
