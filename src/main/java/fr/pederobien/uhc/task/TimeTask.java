package fr.pederobien.uhc.task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import fr.pederobien.uhc.observer.IObsTimeTask;

public class TimeTask extends TimerTask {
	private LocalTime totalTime, increasingTime, decreasingTime, pauseTime, fractionTime;
	private List<IObsTimeTask> observers;
	private boolean pause;
	private int increment;
	
	private void initialize(LocalTime time, LocalTime fractionTime, int increment) {
		observers = new ArrayList<IObsTimeTask>();
		totalTime = increasingTime = pauseTime = LocalTime.of(0, 0, 0);
		decreasingTime = time;
		pause = false;
		this.fractionTime = fractionTime;
		this.increment = increment;
	}
	
	public TimeTask(LocalTime gameTime, LocalTime fractionTime, int increment) {
		initialize(gameTime, fractionTime, increment);
	}
	
	public TimeTask(String gameTime, String fractionTime, int increment) {
		initialize(LocalTime.parse(gameTime), LocalTime.parse(fractionTime), increment);
	}

	@Override
	public void run() {
		timeChanged();
		if (!pause) {
			increasingTime = increasingTime.plusSeconds(increment);
			decreasingTime = decreasingTime.minusSeconds(increment);
		}
		else
			pauseTime = pauseTime.plusSeconds(increment);
		totalTime = totalTime.plusSeconds(increment);
	}
	
	/**
	 * Tell the timetask to stop or not the time in the timetask.
	 * If the task is running then it stop. If the task is stopped then it run.
	 * @return True if the task is stopped, false if the task is running.
	 */
	public void ToPause() {
		this.pause = !pause;
	}
	
	/**
	 * Add an observer to the list of {@link IObsTimeTask} of the task.
	 * @param obs The observer to add to the list.
	 */
	public void addObserver(IObsTimeTask obs) {
		observers.add(obs);
	}
	
	/**
	 * Remove the observer from the list of {@link IObsTimeTask} of the task.
	 * @param obs The observer to remove.
	 */
	public void removeObserver(IObsTimeTask obs) {
		observers.remove(obs);
	}
	
	private void timeChanged() {
		for (IObsTimeTask obs : observers)
			obs.timeChanged(increasingTime);
	}
	
	public LocalTime getTotalTime() {
		return totalTime;
	}
	
	public LocalTime getIncreasingTime() {
		return increasingTime;
	}
	
	public LocalTime getDecreasingTime() {
		return decreasingTime;
	}
	
	public LocalTime getPauseTime() {
		return pauseTime;
	}
	
	public LocalTime getFractionTime() {
		return fractionTime;
	}
}
