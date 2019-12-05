package fr.pederobien.uhc.interfaces;

public interface IAvailableEdition<T> {

	boolean isAvailable();

	T setAvailable(boolean available);
}
