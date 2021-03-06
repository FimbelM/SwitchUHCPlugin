package fr.martinfimbel.switchuhc.interfaces;

public interface IEditionAvailable<T extends IUnmodifiableName> {

	IMapEdition<T> setUnmodifiable(boolean unmodifiable);

	boolean isUnmodifiable();

	IMapEdition<T> setAvailable(boolean available);

	boolean isAvailable();
}
