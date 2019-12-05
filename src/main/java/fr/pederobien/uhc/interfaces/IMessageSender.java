package fr.pederobien.uhc.interfaces;

import fr.pederobien.uhc.observers.IObsMessageSender;

public interface IMessageSender<T> {
	
	T addObserver(IObsMessageSender obs);
	
	T removeObserver(IObsMessageSender obs);
}
