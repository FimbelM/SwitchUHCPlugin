package fr.pederobien.uhc.observer;

public interface IObsPersistence {
	
	void onBeforeLaunching();

	void onLoaded();
	
	void onNewCreated();
}
