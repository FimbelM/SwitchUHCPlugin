package fr.martinfimbel.switchuhc.interfaces;

import java.time.LocalTime;

import org.bukkit.block.Block;

public interface ISwitchGameConfiguration extends IConfiguration, IUnmodifiableSwitchConfiguration {

	void setBorderCenter(Block borderCenter);

	void setBorderCenter(String x, String z);

	void setInitialBorderDiameter(double initialBorderDiameter);

	void setFinalBorderDiameter(double finalBorderDiameter);

	void setFractionTime(LocalTime fractionTime);

	void setWarningTime(LocalTime warningTime);

	void setPvpTime(LocalTime pvpTime);

	void setBorderSpeed(double blocksPerSeconds);
		
	void setPeriodSwitchTime(LocalTime switchTime);
	 
	void setStartSwitchTime(LocalTime startSwitch);
	
	void setNumberOfPlayerSwitchable(Integer numberOfPlayerSwitchable);
	
	void setSwitchAfterBorderMoves(String letter);
	
}
