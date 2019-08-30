package fr.pederobien.uhc.conf.persistence;

public interface IPersistence<T> {
	 
	T load(String name);
	
	void save();
	
	void save(T toSave);
}
