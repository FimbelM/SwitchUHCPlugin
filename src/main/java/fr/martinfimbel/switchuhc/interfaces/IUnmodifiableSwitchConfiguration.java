package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

public interface IUnmodifiableSwitchConfiguration extends IUnmodifiableBorderConfiguration {
	
	LocalTime getFractionTime();
	
	LocalTime getWarningTime();
	
	LocalTime getPeriodSwitchTime();
	
	LocalTime getStartSwitchTime();

	LocalTime getPvpTime();

	Integer getNumberOfPlayerSwitchable();
	
	String getSwitchAfterBorderMoves();
	
	String getReviveNearTeamate();
	
	String getOnePlayerSwitch();

}
