package fr.pederobien.uhc.interfaces;

public interface IWithChildEdition<T extends IUnmodifiableName> extends IEdition, IEditionAvailable {

	IWithChildEdition<T> addEdition(IMapEdition<T> edition);
	
	IWithChildEdition<T> removeEdition(IMapEdition<T> edition);
}
