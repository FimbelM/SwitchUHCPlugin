package fr.pederobien.uhc.interfaces;

public interface IModifiableEdition<T> {

	boolean isModifiable();

	T setModifiable(boolean modifiable);
}
