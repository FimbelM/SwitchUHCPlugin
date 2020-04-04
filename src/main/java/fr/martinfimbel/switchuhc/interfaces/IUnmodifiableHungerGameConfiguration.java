package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

public interface IUnmodifiableHungerGameConfiguration extends IUnmodifiableBorderConfiguration {

	LocalTime getFractionTime();

	LocalTime getWarningTime();

	LocalTime getPvpTime();
}
