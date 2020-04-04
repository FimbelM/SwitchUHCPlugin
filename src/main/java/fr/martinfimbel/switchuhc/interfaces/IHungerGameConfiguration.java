package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

public interface IHungerGameConfiguration extends IBorderConfiguration, IUnmodifiableHungerGameConfiguration {

	void setFractionTime(LocalTime fractionTime);

	void setWarningTime(LocalTime warningTime);

	void setPvpTime(LocalTime pvpTime);
}
