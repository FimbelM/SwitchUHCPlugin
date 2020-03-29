package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

public interface IUnmodifiableSwitchConfiguration extends IUnmodifiableConfiguration {

	Block getBorderCenter();

	Double getInitialBorderDiameter();

	Double getFinalBorderDiameter();

	LocalTime getFractionTime();
	
	LocalTime getWarningTime();
	
	LocalTime getSwitchTime();
	
	LocalTime getStartSwitchTime();

	LocalTime getPvpTime();

	Double getBorderSpeed();

}