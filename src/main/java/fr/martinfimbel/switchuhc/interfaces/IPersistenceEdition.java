package fr.martinfimbel.switchuhc.interfaces;

public interface IPersistenceEdition<T extends IUnmodifiableName> {

	IPersistence<T> getPersistence();

	T get();
}
