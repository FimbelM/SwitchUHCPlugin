package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

public interface IUnmodifiableHungerGameConfiguration extends IUnmodifiableConfiguration {

	Block getBorderCenter();

	Double getInitialBorderDiameter();

	Double getFinalBorderDiameter();

	LocalTime getFractionTime();

	LocalTime getWarningTime();

	LocalTime getPvpTime();

	Double getBorderSpeed();
}
