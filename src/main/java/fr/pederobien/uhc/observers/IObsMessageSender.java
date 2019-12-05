package fr.pederobien.uhc.observers;

import fr.pederobien.uhc.event.MessageEvent;

public interface IObsMessageSender {
	
	void sendMessage(MessageEvent event);	
}
