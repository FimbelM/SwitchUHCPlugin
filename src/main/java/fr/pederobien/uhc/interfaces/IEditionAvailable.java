package fr.pederobien.uhc.interfaces;

public interface IEditionAvailable<T extends IUnmodifiableName> {

	IMapEdition<T> setAvailable(boolean available);
	
	boolean isAvailable();
}
