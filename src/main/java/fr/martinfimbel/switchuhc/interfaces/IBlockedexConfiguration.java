package fr.martinfimbel.switchuhc.interfaces;

public interface IBlockedexConfiguration extends IConfiguration, IUnmodifiableBlockedexConfiguration {

	void setRadiusAreaOnPlayerDie(int radiusAreaOnPlayerDie);

	void setStepOnMaxHealth(double stepHealth);

	void setDiameterAreaOnPlayerRespawn(int diameterArea);

	void setRadiusAreaOnPlayerKill(int radiusAreaOnPlayerKill);

	void setNorthBase(String northBase);

	void setSouthBase(String southBase);

	void setWestBase(String westBase);

	void setEastBase(String eastBase);

	void setBaseFromSpawnDistance(int baseFromSpawnDistance);
}
