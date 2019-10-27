package fr.pederobien.uhc.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

public interface IHungerGameConfiguration extends IConfiguration, IUnmodifiableHungerGameConfiguration {

	void setBorderCenter(Block borderCenter);
	
	void setBorderCenter(String x, String z);
	
	void setInitialBorderDiameter(double initialBorderDiameter);
	
	void setFinalBorderDiameter(double finalBorderDiameter);
	
	void setFractionTime(LocalTime fractionTime);
	
	void setWarningTime(LocalTime warningTime);
}
