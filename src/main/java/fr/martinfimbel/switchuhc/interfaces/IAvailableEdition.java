package fr.martinfimbel.switchuhc.interfaces;

public interface IAvailableEdition<T> {

	boolean isAvailable();

	T setAvailable(boolean available);
}
