package fr.martinfimbel.switchuhc.task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.martinfimbel.switchuhc.observers.IObsLoopTimeLine;
import fr.martinfimbel.switchuhc.observers.IObsTimeLine;
import fr.martinfimbel.switchuhc.observers.IObsTimeTask;

public class TimeLine implements IObsTimeTask {
	private HashMap<LocalTime, List<IObsTimeLine>> ponctualMap;
	private HashMap<LocalTime, List<IObsLoopTimeLine>> repetitiveMap;

	public TimeLine(TimeTask task) {
		ponctualMap = new HashMap<>();
		repetitiveMap = new HashMap<>();
		task.addObserver(this);
	}

	public void addPonctualObserver(LocalTime time, IObsTimeLine obs) {
		addObserverToMap(ponctualMap, time, obs);
	}

	public void removeObserver(LocalTime time, IObsTimeLine obs) {
		ponctualMap.get(time).remove(obs);
		if (ponctualMap.get(time).size() == 0)
			ponctualMap.remove(time);
	}

	@Override
	public void timeChanged(TimeTask task) {
		List<IObsTimeLine> ponctualList = ponctualMap.get(task.getIncreasingTime());
		if (ponctualList != null)
			for (IObsTimeLine function : ponctualList)
				function.time(task.getIncreasingTime());
		List<IObsLoopTimeLine> loopFranzList = repetitiveMap.get(task.getIncreasingTime());
		if (loopFranzList != null)
			for (IObsLoopTimeLine obs : loopFranzList) {
				obs.time(task.getIncreasingTime());
				obs.setNextSwitchTime(task.getIncreasingTime().plusNanos(obs.getPeriod().toNanoOfDay()));
				addObserverToMap(repetitiveMap, task.getIncreasingTime().plusNanos(obs.getPeriod().toNanoOfDay()), obs);
			}
	}

	public void addRepetitiveObserver(LocalTime time, IObsLoopTimeLine obs) {
		addObserverToMap(repetitiveMap, time, obs);
	}

	private <T extends IObsTimeLine> void addObserverToMap(Map<LocalTime, List<T>> observers, LocalTime time, T obs) {
		if (observers.containsKey(time))
			observers.get(time).add(obs);
		else {
			List<T> list = new ArrayList<T>();
			list.add(obs);
			observers.put(time, list);
		}
	}
}
