package fr.martinfimbel.switchuhc.interfaces;

public interface IUnmodifiableBlockedexConfiguration extends IUnmodifiableConfiguration {

	Integer getRadiusAreaOnPlayerDie();

	Double getStepOnMaxHealth();

	Double getDoubleStepOnMaxHealth();

	Integer getDiameterAreaOnPlayerRespawn();

	Integer getRadiusAreaOnPlayerKill();

	String getNorthBase();

	String getSouthBase();

	String getWestBase();

	String getEastBase();

	Integer getBaseFromSpawnDistance();
}
