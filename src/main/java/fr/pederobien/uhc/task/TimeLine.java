package fr.pederobien.uhc.task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.pederobien.uhc.observer.IObsTimeLine;
import fr.pederobien.uhc.observer.IObsTimeTask;

public class TimeLine implements IObsTimeTask {
	private HashMap<LocalTime, List<IObsTimeLine>> map;

	public TimeLine(TimeTask task) {
		map = new HashMap<>();
		task.addObserver(this);
	}
	
	public void addObserver(LocalTime time, IObsTimeLine function) {
		if (map.containsKey(time))
			map.get(time).add(function);
		else {
			List<IObsTimeLine> list = new ArrayList<IObsTimeLine>();
			list.add(function);
			map.put(time, list);
		}
	}
	
	public void removeObserver(LocalTime time, IObsTimeLine function) {
		map.get(time).remove(function);
		if (map.get(time).size() == 0)
			map.remove(time);
	}

	@Override
	public void timeChanged(TimeTask task) {
		List<IObsTimeLine> list = map.get(task.getIncreasingTime());
		if (list != null)
			for (IObsTimeLine function : list)
				function.time();
	}
}
