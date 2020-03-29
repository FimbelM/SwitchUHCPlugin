package fr.martinfimbel.switchuhc.observers;

import java.time.LocalTime;

public interface IObsLoopTimeLine extends IObsTimeLine{

	LocalTime getPeriod();
	
	void setNextSwitchTime(LocalTime time);
}
