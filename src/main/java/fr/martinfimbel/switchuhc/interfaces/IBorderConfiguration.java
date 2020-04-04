package fr.martinfimbel.switchuhc.interfaces;

import org.bukkit.block.Block;

public interface IBorderConfiguration extends IConfiguration, IUnmodifiableBorderConfiguration {

	void setBorderCenter(Block borderCenter);

	void setBorderCenter(String x, String z);

	void setInitialBorderDiameter(double initialBorderDiameter);

	void setFinalBorderDiameter(double finalBorderDiameter);

	void setBorderSpeed(double blocksPerSeconds);
	
}
