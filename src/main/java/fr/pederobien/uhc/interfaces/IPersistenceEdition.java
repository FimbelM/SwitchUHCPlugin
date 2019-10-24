package fr.pederobien.uhc.interfaces;

public interface IPersistenceEdition<T extends IUnmodifiableName> {

	IPersistence<T> getPersistence();
	
	T get();
}
