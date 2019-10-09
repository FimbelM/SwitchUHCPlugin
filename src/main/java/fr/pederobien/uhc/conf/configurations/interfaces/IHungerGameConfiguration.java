package fr.pederobien.uhc.conf.configurations.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

import fr.pederobien.uhc.conf.configurations.IConfiguration;

public interface IHungerGameConfiguration extends IConfiguration, IUnmodifiableHungerGameConfiguration {

	void setBorderCenter(Block borderCenter);
	
	void setBorderCenter(String x, String z);
	
	void setInitialBorderDiameter(double initialBorderDiameter);
	
	void setFinalBorderDiameter(double finalBorderDiameter);
	
	void setFractionTime(LocalTime fractionTime);
}
