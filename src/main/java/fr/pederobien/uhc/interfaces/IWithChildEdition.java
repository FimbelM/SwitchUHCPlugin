package fr.pederobien.uhc.interfaces;

import java.util.Map;

public interface IWithChildEdition<T extends IUnmodifiableName> extends IEdition, IEditionAvailable<T> {

	IWithChildEdition<T> addEdition(IMapEdition<T> edition);
	
	IWithChildEdition<T> removeEdition(IMapEdition<T> edition);
	
	Map<String, IMapEdition<T>> getEditions();
}
