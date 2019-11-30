package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.observers.IObsPersistence;

public interface IEditConfiguration<T extends IUnmodifiableName>
		extends IPersistenceEdition<T>, IWithChildEdition<T>, IObsPersistence<T> {
}
