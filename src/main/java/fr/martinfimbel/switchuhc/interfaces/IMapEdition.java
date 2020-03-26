package fr.martinfimbel.switchuhc.interfaces;

import fr.martinfimbel.switchuhc.observers.IObsMessageCodeSender;

public interface IMapEdition<T extends IUnmodifiableName> extends IAvailableEdition<IMapEdition<T>>, IModifiableEdition<IMapEdition<T>>,
		INodeEdition<IMapEdition<T>, IMapEdition<T>>, IMessageCodeSender<IMapEdition<T>>, IObsMessageCodeSender {

	void edit(String[] args);

	void setParent(IPersistenceEdition<T> parent);
}
