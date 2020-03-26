package fr.martinfimbel.switchuhc.interfaces;

import fr.martinfimbel.switchuhc.observers.IObsMessageCodeSender;

public interface IMessageCodeSender<T> {

	T addObserver(IObsMessageCodeSender obs);

	T removeObserver(IObsMessageCodeSender obs);
}
