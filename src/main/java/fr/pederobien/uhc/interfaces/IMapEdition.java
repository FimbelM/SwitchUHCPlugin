package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.dictionary.dictionaries.MessageCode;

public interface IMapEdition<T extends IUnmodifiableName> extends IAvailableEdition<IMapEdition<T>>,
		IModifiableEdition<IMapEdition<T>>, INodeEdition<IMapEdition<T>, IMapEdition<T>> {

	MessageCode edit(String[] args);

	void setParent(IPersistenceEdition<T> parent);
}
