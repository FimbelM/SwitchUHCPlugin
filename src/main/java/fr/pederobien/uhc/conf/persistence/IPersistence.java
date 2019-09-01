package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.util.List;

public interface IPersistence<T> {
	 
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
