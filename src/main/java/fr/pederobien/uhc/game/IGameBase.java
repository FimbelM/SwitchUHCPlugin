package fr.pederobien.uhc.game;

public interface IGameBase<T> {
	
	void start();
	
	void pause(T before);
	
	void stop();
}
