package fr.pederobien.uhc.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

public interface IPersistence<T extends IUnmodifiableName> {

	IPersistence<T> load(String name) throws FileNotFoundException;

	void save();

	T get();

	void set(T elt);

	boolean exist(String name);

	boolean delete(String name);

	boolean isLoaded();

	boolean isSaved();

	List<String> list();
}
