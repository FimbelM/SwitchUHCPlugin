package fr.pederobien.uhc.interfaces;

public interface IBlockedexConfiguration extends IConfiguration, IUnmodifiableBlockedexConfiguration {

	void setRadiusAreaOnPlayerDie(int radiusAreaOnPlayerDie);

	void setStepOnMaxHealth(double stepHealth);

	void setDiameterAreaOnPlayerRespawn(int diameterArea);

	void setRadiusAreaOnPlayerKill(int radiusAreaOnPlayerKill);

	void setNorthBase(IUnmodifiableBase northBase);

	void setSouthBase(IUnmodifiableBase southBase);

	void setWestBase(IUnmodifiableBase westBase);

	void setEastBase(IUnmodifiableBase eastBase);
	
	void setBaseFromSpawnDistance(int baseFromSpawnDistance);
}
