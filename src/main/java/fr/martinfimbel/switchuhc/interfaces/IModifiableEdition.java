package fr.martinfimbel.switchuhc.interfaces;

public interface IModifiableEdition<T> {

	boolean isModifiable();

	T setModifiable(boolean modifiable);
}
