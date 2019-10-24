package fr.pederobien.uhc.interfaces;

public interface IMapEdition<T extends IUnmodifiableName> extends IEdition, IEditionAvailable {

	void setParent(IPersistenceEdition<T> parent);
}
