package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.observer.IObsPersistence;

public interface IEditConfiguration<T extends IUnmodifiableName>
		extends IPersistenceEdition<T>, IWithChildEdition<T>, IObsPersistence<T> {
}
