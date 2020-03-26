package fr.martinfimbel.switchuhc.interfaces;

import fr.martinfimbel.switchuhc.observers.IObsMessageSender;

public interface IMessageSender<T> {

	T addObserver(IObsMessageSender obs);

	T removeObserver(IObsMessageSender obs);
}
