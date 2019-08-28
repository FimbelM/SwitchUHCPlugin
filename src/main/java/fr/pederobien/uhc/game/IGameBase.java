package fr.pederobien.uhc.game;

public interface IGameBase<T extends IGameBaseState> {
	
	void start();
	
	void pause(T before);
	
	void stop();
	
	T getCurrentState();
	
	void relaunched();
}
