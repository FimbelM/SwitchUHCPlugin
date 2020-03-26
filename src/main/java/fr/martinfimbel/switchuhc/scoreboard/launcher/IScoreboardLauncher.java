package fr.martinfimbel.switchuhc.scoreboard.launcher;

import fr.martinfimbel.switchuhc.observers.IObsTimeLine;

public interface IScoreboardLauncher extends IObsTimeLine {

	void run(long delay, long period);

	void start();

	void update();

	void pause();

	void relaunched();

	void stop();

	void cancel();
}
