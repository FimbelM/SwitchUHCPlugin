package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.observer.IObsPersistence;

public interface IEditConfiguration<T extends IUnmodifiableName>
		extends IEdition, IPersistenceEdition<T>, IWithChildEdition<T>, IObsPersistence<T> {

}
