package fr.pederobien.uhc.configurations.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

import fr.pederobien.uhc.configurations.IUnmodifiableConfiguration;

public interface IUnmodifiableHungerGameConfiguration extends IUnmodifiableConfiguration {

	Block getBorderCenter();
	
	Double getInitialBorderDiameter();
	
	Double getFinalBorderDiameter();
	
	LocalTime getFractionTime();
}
