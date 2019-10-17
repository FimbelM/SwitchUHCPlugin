package fr.pederobien.uhc.interfaces;

import java.util.List;

public interface IBlockedexConfiguration extends IConfiguration, IUnmodifiableBlockedexConfiguration {

	void setRadiusAreaOnPlayerDie(int radiusAreaOnPlayerDie);

	void setStepOnMaxHealth(double stepHealth);

	void setDiameterAreaOnPlayerRespawn(int diameterArea);

	void setRadiusAreaOnPlayerKill(int radiusAreaOnPlayerKill);

	void setBases(List<IUnmodifiableBase> bases);
}
