package fr.pederobien.uhc.interfaces;

public interface IMapEdition<T extends IUnmodifiableName> extends IWithChildEdition<T>, IPersistenceEdition<T> {

	void setParent(IPersistenceEdition<T> parent);
	
	IPersistenceEdition<T> getParent();
}
