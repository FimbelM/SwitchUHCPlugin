package fr.pederobien.uhc.conf.configurations.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.configurations.IUnmodifiableConfiguration;

public interface IUnmodifiableHungerGameConfiguration extends IUnmodifiableConfiguration {

	Block getBorderCenter();
	
	Double getInitialBorderDiameter();
	
	Double getFinalBorderDiameter();
	
	LocalTime getFractionTime();
}
