package fr.martinfimbel.switchuhc.task;

public interface ITaskLauncher {

	void run(long delay, long period);

	void pause();

	void cancel();

	void relaunched();

	TimeTask getTask();
}
