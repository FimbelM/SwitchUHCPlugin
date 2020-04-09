package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

public interface ISwitchGameConfiguration extends IBorderConfiguration, IUnmodifiableSwitchConfiguration {

	void setFractionTime(LocalTime fractionTime);

	void setWarningTime(LocalTime warningTime);

	void setPvpTime(LocalTime pvpTime);

	void setPeriodSwitchTime(LocalTime switchTime);

	void setStartSwitchTime(LocalTime startSwitch);

	void setNumberOfPlayerSwitchable(Integer numberOfPlayerSwitchable);

	void setSwitchAfterBorderMoves(String letter);
	
	void setReviveNearTeamate(String letter);

}
