package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.observers.IObsMessageCodeSender;

public interface IMessageCodeSender<T> {

	T addObserver(IObsMessageCodeSender obs);

	T removeObserver(IObsMessageCodeSender obs);
}
