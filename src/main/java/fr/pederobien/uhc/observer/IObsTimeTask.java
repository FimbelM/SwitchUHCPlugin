package fr.pederobien.uhc.observer;

import java.time.LocalTime;

public interface IObsTimeTask {
	
	void timeChanged(LocalTime time);

}
