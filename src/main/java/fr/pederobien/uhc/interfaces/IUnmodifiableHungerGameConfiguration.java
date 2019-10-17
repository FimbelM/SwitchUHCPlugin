package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

public interface IUnmodifiableHungerGameConfiguration extends IUnmodifiableConfiguration {

	Block getBorderCenter();
	
	Double getInitialBorderDiameter();
	
	Double getFinalBorderDiameter();
	
	LocalTime getFractionTime();
}
