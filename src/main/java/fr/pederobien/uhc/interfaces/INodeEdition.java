package fr.pederobien.uhc.interfaces;

import java.util.Map;

public interface INodeEdition<T extends IEdition, U> extends IEdition{

	U addEdition(T elt);

	U removeEdition(T elt);

	Map<String, T> getChildren();
}
