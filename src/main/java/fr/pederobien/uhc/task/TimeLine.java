package fr.pederobien.uhc.task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.pederobien.uhc.observer.IObsTimeTask;
import fr.pederobien.utils.Function;

public class TimeLine implements IObsTimeTask {
	private HashMap<LocalTime, List<Function>> map;

	public TimeLine(TimeTask task) {
		map = new HashMap<>();
		task.addObserver(this);
	}
	
	public void addObserver(LocalTime time, Function function) {
		if (map.containsKey(time))
			map.get(time).add(function);
		else {
			List<Function> list = new ArrayList<Function>();
			list.add(function);
			map.put(time, list);
		}
	}
	
	public void removeObserver(LocalTime time, Function function) {
		map.get(time).remove(function);
		if (map.get(time).size() == 0)
			map.remove(time);
	}

	@Override
	public void timeChanged(LocalTime time) {
		for (Function function : map.get(time))
			function.run();
	}
}
