package fr.pederobien.uhc.scoreboard.launcher;

import fr.pederobien.uhc.observer.IObsTimeLine;

public interface IScoreboardLauncher extends IObsTimeLine {
	
	void run(long delay, long period);

	void start();

	void update();

	void pause();

	void relaunched();

	void stop();
	
	void cancel();
}
