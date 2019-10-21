package fr.pederobien.uhc.interfaces;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import fr.pederobien.uhc.observer.IObsPersistence;
import fr.pederobien.uhc.persistence.loaders.IPersistenceLoader;

public interface IPersistence<T extends IUnmodifiableName> {

	IPersistence<T> load(String name) throws FileNotFoundException;
	
	IPersistence<T> registerLoader(IPersistenceLoader<T> loader);
	
	Map<String, IPersistenceLoader<T>> getLoaders();

	void save();

	T get();

	void set(T elt);

	boolean exist(String name);

	boolean delete(String name);

	boolean isLoaded();

	boolean isSaved();

	List<String> list();
	
	IPersistence<T> addObserver(IObsPersistence obs);
	
	IPersistence<T> removeObserver(IObsPersistence obs);
}
