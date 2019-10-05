package fr.pederobien.uhc.conf.persistence;

import java.io.FileNotFoundException;
import java.util.List;

import fr.pederobien.uhc.conf.IName;

public interface IPersistence<T extends IName> {
	 
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
