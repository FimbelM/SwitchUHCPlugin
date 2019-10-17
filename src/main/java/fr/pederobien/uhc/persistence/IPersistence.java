package fr.pederobien.uhc.persistence;

import java.io.FileNotFoundException;
import java.util.List;

import fr.pederobien.uhc.interfaces.IUnmodifiableName;

public interface IPersistence<T extends IUnmodifiableName> {

	void load(String name) throws FileNotFoundException;

	void save();

	T get();

	void set(T elt);

	boolean exist(String name);

	boolean delete(String name);

	boolean isLoaded();

	boolean isSaved();

	List<String> list();
}
