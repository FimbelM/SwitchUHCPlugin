package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.block.Block;

public interface IUnmodifiableBorderConfiguration extends IUnmodifiableConfiguration {
	
	Block getBorderCenter();

	Double getInitialBorderDiameter();

	Double getFinalBorderDiameter();
	
	Double getBorderSpeed();
}
